package fr.kabiro.lol.ism.core.remote.match;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDetailDTO;

public interface RestMatchClient {
    MatchDetailDTO getMatchDetails(Long matchId, Region region, boolean includeTimeline);
}
