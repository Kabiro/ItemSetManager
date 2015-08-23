package fr.kabiro.lol.ism.core.remote.staticdata;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.staticdata.dto.ChampionListDto;

public interface RestStaticDataClient {
    ChampionListDto champions(Region region);
}
