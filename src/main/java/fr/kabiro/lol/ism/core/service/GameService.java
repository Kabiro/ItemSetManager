package fr.kabiro.lol.ism.core.service;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.game.dto.GameDTO;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDetailDTO;

import java.util.Optional;
import java.util.Set;

public interface GameService {
    Set<GameDTO> recentGamesBySummoner(String name, Region region);

    Optional<MatchDetailDTO> byId(Long id, Region region);
}
