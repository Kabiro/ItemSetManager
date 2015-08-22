package fr.kabiro.lol.ism.core.remote.match;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.RestRiotClient;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDetailDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RestMatchClient extends RestRiotClient {
    private static final String VERSION = "v2.2";

    public RestMatchClient() {
        super(VERSION);
    }

    public MatchDetailDTO getMatchDetails(Long matchId, Region region, boolean includeTimeline) {
        Map<String, Object> params = new HashMap<>();
        params.put("includeTimeline", Boolean.toString(includeTimeline));
        return doGet("/match/" + matchId, region, params, MatchDetailDTO.class);
    }
}
