package fr.kabiro.lol.ism.core.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Sets;
import fr.kabiro.lol.ism.core.dao.BuildDao;
import fr.kabiro.lol.ism.core.dao.ChampionDao;
import fr.kabiro.lol.ism.core.dao.SummonerDao;
import fr.kabiro.lol.ism.core.dto.BuildDto;
import fr.kabiro.lol.ism.core.dto.ItemSetDto;
import fr.kabiro.lol.ism.core.mapper.BuildMapper;
import fr.kabiro.lol.ism.core.mapper.EventMapper;
import fr.kabiro.lol.ism.core.model.Build;
import fr.kabiro.lol.ism.core.model.Champion;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.model.Summoner;
import fr.kabiro.lol.ism.core.pojo.ZipFile;
import fr.kabiro.lol.ism.core.remote.match.RestMatchClient;
import fr.kabiro.lol.ism.core.remote.match.dto.*;
import fr.kabiro.lol.ism.core.service.ItemSetService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemSetServiceImpl implements ItemSetService {

    private BuildDao buildDao;

    private SummonerDao summonerDao;

    private ChampionDao championDao;

    private RestMatchClient matchClient;

    private BuildMapper buildMapper;

    private EventMapper eventMapper;

    private ObjectMapper objectMapper;

    public ItemSetServiceImpl(BuildDao buildDao, SummonerDao summonerDao, ChampionDao championDao, RestMatchClient matchClient, BuildMapper buildMapper, EventMapper eventMapper, ObjectMapper objectMapper) {
        this.buildDao = buildDao;
        this.summonerDao = summonerDao;
        this.championDao = championDao;
        this.matchClient = matchClient;
        this.buildMapper = buildMapper;
        this.eventMapper = eventMapper;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<BuildDto> findItemsSetByUser(String name, Region region) {
        List<Build> builds = buildDao.findBuildsBySummonerNameAndRegion(name, region);
        return buildMapper.entityCollectionToDtoList(builds);
    }

    @Override
    public List<ZipFile> findZippedItemsSetByUser(String name, Region region) {
        List<Build> builds = buildDao.findBuildsBySummonerNameAndRegion(name, region);
        builds.addAll(summonerDao.findByNameAndRegion(name, region).map(Summoner::getFollowedBuilds).orElse(Collections.emptySet()));
        List<ZipFile> zipFiles = new ArrayList<>();
        for (Build build : builds) {
            if (build.getChampions().isEmpty()) {
                zipFiles.add(new ZipFile("Config/Global/Recommended/itemSetManager_" + build.getId() + ".json", build.getJson().getBytes()));
            } else {
                for (Champion champion : build.getChampions()) {
                    zipFiles.add(new ZipFile("Config/Champions/" + champion.getKey() + "/Recommended/itemSetManager_" + build.getId() + ".json", build.getJson().getBytes()));
                }
            }
        }
        return zipFiles;
    }

    @Override
    public Map<Integer, ItemSetDto> itemsSetFromGame(String gameId, Region region) {
        MatchTimelineDto timeline = matchClient.getTimeline(gameId, region);
        List<FrameDto> frames = timeline.info.frames;

        Map<Integer, List<ItemFrameEventDto>> eventsByParticipant = frames.stream()
                .flatMap(frame -> frame.events.stream())
                .filter(event -> event instanceof ItemFrameEventDto)
                .map(event -> ((ItemFrameEventDto) event))
                .collect(Collectors.groupingBy(event -> event.participantId));

        return eventsByParticipant.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> eventMapper.eventsToItemSet(entry.getValue())));
    }

    @Override
    public Optional<BuildDto> findItemsSetById(Long id) {
        return buildDao.findById(id).map(buildMapper::entityToDto);
    }

    @Override
    public List<BuildDto> findFollowedItemsSetByUser(String name, Region region) {
        return summonerDao.findByNameAndRegion(name, region)
                .map(Summoner::getFollowedBuilds)
                .map(buildMapper::entityCollectionToDtoList)
                .orElse(Collections.emptyList());
    }

    @Override
    public void followItemSet(String name, Region region, Long buildId) {
        Optional<Summoner> summoner = summonerDao.findByNameAndRegion(name, region);
        Optional<Build> build = buildDao.findById(buildId);
        if (build.isPresent() && summoner.isPresent()) {
            summoner.get().getFollowedBuilds().add(build.get());
            summonerDao.save(summoner.get());
        }
    }

    @Override
    public void unfollowItemSet(String name, Region region, Long buildId) {
        Optional<Summoner> summoner = summonerDao.findByNameAndRegion(name, region);
        Optional<Build> build = buildDao.findById(buildId);
        if (build.isPresent() && summoner.isPresent()) {
            summoner.get().getFollowedBuilds().remove(build.get());
            summonerDao.save(summoner.get());
        }
    }

    @Override
    public BuildDto create(Set<String> champions, String summonerName, Region summonerRegion, ItemSetDto itemSet) {
        try {
            Set<Champion> champs = Sets.newHashSet(championDao.findAllById(champions));
            Optional<Summoner> summoner = summonerDao.findByNameAndRegion(summonerName, summonerRegion);
            Build build = Build.builder()
                    .champions(champs)
                    .json(objectMapper.writeValueAsString(itemSet))
                    .summoner(summoner.get())
                    .build();
            buildDao.save(build);
            return buildMapper.entityToDto(build);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BuildDto update(Long buildId, Set<String> champions, ItemSetDto itemSet) {
        try {
            Build build = buildDao.findById(buildId).get();
            Set<Champion> champs = Sets.newHashSet(championDao.findAllById(champions));
            build.setChampions(champs);
            build.setJson(objectMapper.writeValueAsString(itemSet));
            buildDao.save(build);
            return buildMapper.entityToDto(build);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long buildId) {
        buildDao.deleteById(buildId);
    }
}
