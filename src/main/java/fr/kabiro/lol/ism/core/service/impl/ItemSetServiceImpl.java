package fr.kabiro.lol.ism.core.service.impl;

import fr.kabiro.lol.ism.Utils;
import fr.kabiro.lol.ism.core.dao.BuildDao;
import fr.kabiro.lol.ism.core.dto.file.ItemSetDto;
import fr.kabiro.lol.ism.core.mapper.BuildMapper;
import fr.kabiro.lol.ism.core.mapper.EventMapper;
import fr.kabiro.lol.ism.core.model.Build;
import fr.kabiro.lol.ism.core.model.Champion;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.pojo.ZipFile;
import fr.kabiro.lol.ism.core.remote.match.RestMatchClient;
import fr.kabiro.lol.ism.core.remote.match.dto.EventDTO;
import fr.kabiro.lol.ism.core.remote.match.dto.EventTypeDTO;
import fr.kabiro.lol.ism.core.remote.match.dto.FrameDTO;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDetailDTO;
import fr.kabiro.lol.ism.core.service.ItemSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemSetServiceImpl implements ItemSetService {

    @Autowired
    private BuildDao buildDao;

    @Autowired
    private RestMatchClient matchClient;

    @Autowired
    private BuildMapper buildMapper;

    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<ItemSetDto> findItemsSetByUser(String name, Region region) {
        List<Build> builds = buildDao.findBuildsBySummonerNameAndRegion(name, region);
        return buildMapper.entityCollectionToDtoList(builds);
    }

    @Override
    public List<ZipFile> findZippedItemsSetByUser(String name, Region region) {
        List<Build> builds = buildDao.findBuildsBySummonerNameAndRegion(name, region);
        List<ZipFile> zipFiles = new ArrayList<>();
        for (Build build : builds) {
            if (build.getChampions().isEmpty()) {
                zipFiles.add(new ZipFile("Global/Recommended/" + build.getId() + ".json", build.getJson().getBytes()));
            } else {
                for (Champion champion : build.getChampions()) {
                    zipFiles.add(new ZipFile("Champions/" + champion.getKey() + "/Recommended/" + build.getId() + ".json", build.getJson().getBytes()));
                }
            }
        }
        return zipFiles;
    }

    @Override
    public List<ItemSetDto> itemsSetFromGame(Long gameId, Region region) {
        MatchDetailDTO details = matchClient.getMatchDetails(gameId, region, true);
        List<FrameDTO> frames = details.getTimeline().getFrames();

        Map<Integer, List<EventDTO>> eventsByParticipant = frames.stream()
                .flatMap(frame -> Utils.safe(frame.getEvents()).stream())
                .filter(event -> event.getEventType() == EventTypeDTO.ITEM_PURCHASED)
                .collect(Collectors.groupingBy(EventDTO::getParticipantId));

        return eventsByParticipant.values().stream()
                .map(eventMapper::eventsToItemSet)
                .collect(Collectors.toList());
    }
}
