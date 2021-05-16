package fr.kabiro.lol.ism.core.service.impl;

import fr.kabiro.lol.ism.core.dto.SummonerDto;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.match.RestMatchClient;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDto;
import fr.kabiro.lol.ism.core.service.GameService;
import fr.kabiro.lol.ism.core.service.SummonerService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private SummonerService summonerService;

    private RestMatchClient matchClient;

    public GameServiceImpl(SummonerService summonerService, RestMatchClient matchClient) {
        this.summonerService = summonerService;
        this.matchClient = matchClient;
    }

    @Override
    public List<MatchDto> recentGamesBySummoner(String name, Region region) {
        Optional<SummonerDto> summoner = summonerService.findByNameAndRegion(name, region);
        return summoner
                .stream()
                .flatMap(summonerDto -> matchClient.getRecentMatchesIdsByPuuid(summonerDto.getPuuid(), region).stream())
                .limit(5)
                .map(matchId -> matchClient.getMatch(matchId, region))
                .sorted(Comparator.comparing(match -> match.info.gameStartTimestamp))
                .collect(Collectors.toList());
    }

    @Override
    public MatchDto byId(String id, Region region) {
        return matchClient.getMatch(id, region);
    }
}
