package fr.kabiro.lol.ism.core.dao;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.model.Summoner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SummonerDao extends CrudRepository<Summoner, Long> {

    Optional<Summoner> findByNameAndRegion(String name, Region region);
}
