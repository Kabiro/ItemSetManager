package fr.kabiro.lol.ism.core.controller;

import fr.kabiro.lol.ism.core.dto.file.ItemSetDto;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.service.ItemSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemSetController {

    @Autowired
    private ItemSetService itemSetService;

    @RequestMapping("/api/sets/v1/{name}/{region}/")
    public List<ItemSetDto> itemsSetByUser(@PathVariable("name") String name, @PathVariable("region") Region region) {
        return itemSetService.findItemsSetByUser(name, region);
    }

}
