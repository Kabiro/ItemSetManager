package fr.kabiro.lol.ism.core.dao;

import fr.kabiro.lol.ism.core.model.Build;
import fr.kabiro.lol.ism.core.model.Region;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BuildDao extends CrudRepository<Build, Long> {

    @Query("SELECT b FROM Build b JOIN b.summoner s WHERE s.name = :name and s.region = :region")
    List<Build> findBuildsBySummonerNameAndRegion(@Param("name") String name, @Param("region") Region region);

    Optional<Build> findById(Long id);
}
