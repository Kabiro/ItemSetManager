package fr.kabiro.lol.ism.core.remote.match;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDto;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchListDto;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchTimelineDto;

public interface RestMatchClient {
    MatchListDto getRecentMatchesByAccount(String accountId, Region region);

    MatchTimelineDto getTimeline(Long matchId, Region region);

    MatchDto getMatch(Long matchId, Region region);
}
