package fr.kabiro.lol.ism.core.mapper;

import fr.kabiro.lol.ism.core.dto.*;
import fr.kabiro.lol.ism.core.remote.match.dto.EventDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class EventMapper {

    public ItemSetDto eventsToItemSet(Collection<EventDTO> events) {
        ItemSetDto itemSet = new ItemSetDto();
        itemSet.setTitle("The name of the page");
        itemSet.setType(TypeDto.custom);
        itemSet.setMode(ModeDto.any);
        itemSet.setMap(MapDto.any);
        int index = 0;
        BlockDto block = null;
        for (EventDTO event : events) {
            if (index % 16 == 0) {
                block = new BlockDto();
                itemSet.getBlocks().add(block);
                block.setType("Block number " + index / 16);
            }
            ItemDto item = new ItemDto();
            item.setId(event.getItemId());
            block.getItems().add(item);
            index++;
        }
        return itemSet;
    }
}
