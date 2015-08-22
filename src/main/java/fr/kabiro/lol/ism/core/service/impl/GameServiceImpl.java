package fr.kabiro.lol.ism.core.service.impl;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.model.Summoner;
import fr.kabiro.lol.ism.core.remote.game.RestGamesClient;
import fr.kabiro.lol.ism.core.remote.game.dto.GameDTO;
import fr.kabiro.lol.ism.core.service.GameService;
import fr.kabiro.lol.ism.core.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private SummonerService summonerService;

    @Autowired
    private RestGamesClient gamesClient;

    @Override
    public Set<GameDTO> recentGamesBySummoner(String name, Region region) {
        Optional<Summoner> summoner = summonerService.findByNameAndRegion(name, region);
        if (summoner.isPresent()) {
            Long riotId = summoner.get().getRiotId();
            return gamesClient.getRecentGamesBySummonerId(riotId, region).getGames();
        }
        return Collections.emptySet();
    }
}
