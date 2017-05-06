package fr.kabiro.lol.ism.core.remote.summoner;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.summoner.dto.SummonerDTO;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface RestSummonerClient {
    Optional<SummonerDTO> getSummonerByName(String name, Region region);
}
