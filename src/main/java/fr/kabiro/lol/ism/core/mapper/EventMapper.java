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
        BlockDto block = new BlockDto();
        block.setType("All items");
        for (EventDTO event : events) {
            ItemDto item = new ItemDto();
            item.setId(event.getItemId());
            block.getItems().add(item);
        }
        itemSet.getBlocks().add(block);
        return itemSet;
    }
}
