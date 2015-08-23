package fr.kabiro.lol.ism.core.service;

import fr.kabiro.lol.ism.core.dto.BuildDto;
import fr.kabiro.lol.ism.core.dto.ItemSetDto;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.pojo.ZipFile;

import java.util.List;

public interface ItemSetService {
    List<BuildDto> findItemsSetByUser(String name, Region region);

    List<ZipFile> findZippedItemsSetByUser(String name, Region region);

    List<ItemSetDto> itemsSetFromGame(Long gameId, Region region);
}
