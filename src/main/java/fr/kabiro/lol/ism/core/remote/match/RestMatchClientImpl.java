package fr.kabiro.lol.ism.core.remote.match;

import fr.kabiro.lol.ism.config.Profils;
import fr.kabiro.lol.ism.config.RiotApiConfig;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.RestRiotClient;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDto;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchListDto;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchTimelineDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.Collections;

@Component
@Profile(Profils.NOT_MOCK_RIOT)
public class RestMatchClientImpl extends RestRiotClient implements RestMatchClient {

    public RestMatchClientImpl(RiotApiConfig riotApiConfig, RestOperations restOperations) {
        super(riotApiConfig, restOperations);
    }

    @Override
    public MatchListDto getRecentMatchesByAccount(String accountId, Region region) {
        String url = "/lol/match/v3/matchlists/by-account/" + accountId + "/recent";
        return doGet(url, region, Collections.emptyMap(), MatchListDto.class);
    }

    @Override
    public MatchTimelineDto getTimeline(Long matchId, Region region) {
        String url = "/lol/match/v3/timelines/by-match/" + matchId;
        return doGet(url, region, Collections.emptyMap(), MatchTimelineDto.class);
    }

    @Override
    public MatchDto getMatch(Long matchId, Region region) {
        String url = "/lol/match/v3/matches/" + matchId;
        return doGet(url, region, Collections.emptyMap(), MatchDto.class);
    }
}
