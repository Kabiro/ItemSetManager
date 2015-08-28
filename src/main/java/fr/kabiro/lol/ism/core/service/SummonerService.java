package fr.kabiro.lol.ism.core.service;

import fr.kabiro.lol.ism.core.dto.SummonerDto;
import fr.kabiro.lol.ism.core.model.Region;

import java.util.Optional;

public interface SummonerService {
    Optional<SummonerDto> findByNameAndRegion(String name, Region region);
}
