package fr.kabiro.lol.ism.core.remote.match;

import fr.kabiro.lol.ism.config.Profils;
import fr.kabiro.lol.ism.config.RiotApiConfig;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.RestRiotClient;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDto;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchTimelineDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.Collections;
import java.util.List;

@Component
@Profile(Profils.NOT_MOCK_RIOT)
public class RestMatchClientImpl extends RestRiotClient implements RestMatchClient {

    public RestMatchClientImpl(RiotApiConfig riotApiConfig, RestOperations restOperations) {
        super(riotApiConfig, restOperations);
    }

    @Override
    public List<String> getRecentMatchesIdsByPuuid(String puuid, Region region) {
        String url = "/lol/match/v5/matches/by-puuid/" + puuid + "/ids";
        return doGet(url, region, true, Collections.emptyMap(), List.class);
    }

    @Override
    public MatchTimelineDto getTimeline(String matchId, Region region) {
        String url = "/lol/match/v5/matches/" + matchId + "/timeline";
        return doGet(url, region, true, Collections.emptyMap(), MatchTimelineDto.class);
    }

    @Override
    public MatchDto getMatch(String matchId, Region region) {
        String url = "/lol/match/v5/matches/" + matchId;
        return doGet(url, region, true, Collections.emptyMap(), MatchDto.class);
    }
}
