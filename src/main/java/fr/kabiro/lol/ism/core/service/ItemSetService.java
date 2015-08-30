package fr.kabiro.lol.ism.core.service;

import fr.kabiro.lol.ism.core.dto.BuildDto;
import fr.kabiro.lol.ism.core.dto.ItemSetDto;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.pojo.ZipFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ItemSetService {
    List<BuildDto> findItemsSetByUser(String name, Region region);

    List<ZipFile> findZippedItemsSetByUser(String name, Region region);

    Map<Integer, ItemSetDto> itemsSetFromGame(Long gameId, Region region);

    Optional<BuildDto> findItemsSetById(Long id);

    List<BuildDto> findFollowedItemsSetByUser(String name, Region region);

    void followItemSet(String name, Region region, Long buildId);

    void unfollowItemSet(String name, Region region, Long buildId);
}
