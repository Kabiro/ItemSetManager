package fr.kabiro.lol.ism.core.remote.match;

import fr.kabiro.lol.ism.config.Profils;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.RestRiotClient;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDetailDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Profile(Profils.NOT_MOCK_RIOT)
public class RestMatchClientImpl extends RestRiotClient implements RestMatchClient {
    private static final String VERSION = "v2.2";

    public RestMatchClientImpl() {
        super(VERSION);
    }

    @Override
    public MatchDetailDTO getMatchDetails(Long matchId, Region region, boolean includeTimeline) {
        Map<String, Object> params = new HashMap<>();
        params.put("includeTimeline", Boolean.toString(includeTimeline));
        return doGet("/match/" + matchId, region, params, MatchDetailDTO.class);
    }
}
