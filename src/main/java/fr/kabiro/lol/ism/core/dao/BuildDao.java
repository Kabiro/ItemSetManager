package fr.kabiro.lol.ism.core.dao;

import fr.kabiro.lol.ism.core.model.Build;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuildDao extends CrudRepository<Build, Long> {

    //List<Build> findBuildsBySummonerNameAndRegion();
}
