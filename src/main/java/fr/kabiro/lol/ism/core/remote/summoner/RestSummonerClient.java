package fr.kabiro.lol.ism.core.remote.summoner;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.summoner.dto.SummonerDTO;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface RestSummonerClient {
    Set<SummonerDTO> getSummonersByNames(Collection<String> names, Region region);

    Optional<SummonerDTO> getSummonerByName(String name, Region region);

    Map<Long, SummonerDTO> getSummonersByRiotIds(Collection<Long> riotIds, Region region);

    Optional<SummonerDTO> getSummonerByRiotId(Long id, Region region);
}
