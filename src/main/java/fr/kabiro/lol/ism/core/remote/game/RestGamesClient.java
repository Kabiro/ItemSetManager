package fr.kabiro.lol.ism.core.remote.game;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.game.dto.RecentGamesDTO;

public interface RestGamesClient {
    RecentGamesDTO getRecentGamesBySummonerId(Long riotId, Region region);
}
