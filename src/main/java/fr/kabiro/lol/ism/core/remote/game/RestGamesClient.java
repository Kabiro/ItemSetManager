package fr.kabiro.lol.ism.core.remote.game;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.RestRiotClient;
import fr.kabiro.lol.ism.core.remote.game.dto.RecentGamesDTO;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class RestGamesClient extends RestRiotClient {


    private final static String VERSION = "v1.3";

    public RestGamesClient() {
        super(VERSION);
    }


    public RecentGamesDTO getRecentGamesBySummonerId(Long riotId, Region region) {
        return doGet("/game/by-summoner/" + riotId + "/recent", region, Collections.emptyMap(), RecentGamesDTO.class);
    }
}
