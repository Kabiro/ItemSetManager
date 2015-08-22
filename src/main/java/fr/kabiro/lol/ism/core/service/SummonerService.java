package fr.kabiro.lol.ism.core.service;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.model.Summoner;

import java.util.Optional;

public interface SummonerService {
    Optional<Summoner> findByNameAndRegion(String name, Region region);
}
