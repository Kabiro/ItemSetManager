package fr.kabiro.lol.ism.core.service;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.game.dto.GameDTO;

import java.util.Set;

public interface GameService {
    Set<GameDTO> recentGamesBySummoner(String name, Region region);
}
