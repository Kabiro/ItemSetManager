package fr.kabiro.lol.ism.core.service.impl;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.staticdata.RestStaticDataClient;
import fr.kabiro.lol.ism.core.remote.staticdata.dto.ChampionListDto;
import fr.kabiro.lol.ism.core.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChampionServiceImpl implements ChampionService {

    @Autowired
    private RestStaticDataClient staticDataClient;

    @Autowired
    private Region defaultRegion;

    @Override
    public ChampionListDto getAll() {
        return staticDataClient.champions(defaultRegion);
    }
}
