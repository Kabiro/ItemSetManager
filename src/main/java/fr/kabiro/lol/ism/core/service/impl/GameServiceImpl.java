package fr.kabiro.lol.ism.core.service.impl;

import fr.kabiro.lol.ism.core.dto.SummonerDto;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.match.RestMatchClient;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDto;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchReferenceDto;
import fr.kabiro.lol.ism.core.service.GameService;
import fr.kabiro.lol.ism.core.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private SummonerService summonerService;

    @Autowired
    private RestMatchClient matchClient;

    @Override
    public List<MatchReferenceDto> recentGamesBySummoner(String name, Region region) {
        Optional<SummonerDto> summoner = summonerService.findByNameAndRegion(name, region);
        return summoner
                .map(summonerDto -> matchClient.getRecentMatchesByAccount(summonerDto.getAccountId(), region).matches)
                .orElseGet(Collections::emptyList);
    }

    @Override
    public MatchDto byId(Long id, Region region) {
        return matchClient.getMatch(id, region);
    }
}
