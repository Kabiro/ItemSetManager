package fr.kabiro.lol.ism.core.service.impl;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.staticdata.RestStaticDataClient;
import fr.kabiro.lol.ism.core.remote.staticdata.dto.ChampionListDto;
import fr.kabiro.lol.ism.core.service.ChampionService;
import org.springframework.stereotype.Service;

@Service
public class ChampionServiceImpl implements ChampionService {

    private RestStaticDataClient staticDataClient;

    private Region defaultRegion;

    public ChampionServiceImpl(RestStaticDataClient staticDataClient, Region defaultRegion) {
        this.staticDataClient = staticDataClient;
        this.defaultRegion = defaultRegion;
    }

    @Override
    public ChampionListDto getAll() {
        return staticDataClient.champions(defaultRegion);
    }
}
