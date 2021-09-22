package fr.kabiro.lol.ism.core.remote.match;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDto;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchTimelineDto;

import java.util.List;

public interface RestMatchClient {
    List<String> getRecentMatchesIdsByPuuid(String accountId, Region region);

    MatchTimelineDto getTimeline(String matchId, Region region);

    MatchDto getMatch(String matchId, Region region);
}
