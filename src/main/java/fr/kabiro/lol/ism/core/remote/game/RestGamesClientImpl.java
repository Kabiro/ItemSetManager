package fr.kabiro.lol.ism.core.remote.game;

import fr.kabiro.lol.ism.config.Profils;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.RestRiotClient;
import fr.kabiro.lol.ism.core.remote.game.dto.RecentGamesDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@Profile(Profils.NOT_MOCK_RIOT)
public class RestGamesClientImpl extends RestRiotClient implements RestGamesClient {


    private final static String VERSION = "v1.3";

    public RestGamesClientImpl() {
        super(VERSION);
    }

    @Override
    public RecentGamesDTO getRecentGamesBySummonerId(Long riotId, Region region) {
        return doGet("/game/by-summoner/" + riotId + "/recent", region, Collections.emptyMap(), RecentGamesDTO.class);
    }
}
