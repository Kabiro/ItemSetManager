package fr.kabiro.lol.ism.core.service;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDto;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchReferenceDto;

import java.util.List;

public interface GameService {
    List<MatchReferenceDto> recentGamesBySummoner(String name, Region region);

    MatchDto byId(Long id, Region region);
}
