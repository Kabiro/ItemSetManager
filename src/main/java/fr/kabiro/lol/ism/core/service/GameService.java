package fr.kabiro.lol.ism.core.service;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.model.match.MatchSummary;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDto;

import java.util.List;

public interface GameService {
    List<MatchSummary> recentGamesBySummoner(String name, Region region);

    MatchDto byId(String id, Region region);
}
