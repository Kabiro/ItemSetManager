package fr.kabiro.lol.ism.core.dao;

import fr.kabiro.lol.ism.core.model.Champion;
import org.springframework.data.repository.CrudRepository;

public interface ChampionDao extends CrudRepository<Champion, String> {
}
