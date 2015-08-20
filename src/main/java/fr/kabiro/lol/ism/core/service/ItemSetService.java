package fr.kabiro.lol.ism.core.service;

import fr.kabiro.lol.ism.core.dto.file.ItemSetDto;
import fr.kabiro.lol.ism.core.model.Region;

import java.util.List;

public interface ItemSetService {
    List<ItemSetDto> findItemsSetByUser(String name, Region region);
}
