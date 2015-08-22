package fr.kabiro.lol.ism.core.mapper;

import fr.kabiro.lol.ism.core.dto.file.BlockDto;
import fr.kabiro.lol.ism.core.dto.file.ItemDto;
import fr.kabiro.lol.ism.core.dto.file.ItemSetDto;
import fr.kabiro.lol.ism.core.remote.match.dto.EventDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class EventMapper {

    public ItemSetDto eventsToItemSet(Collection<EventDTO> events) {
        ItemSetDto itemSet = new ItemSetDto();
        BlockDto block = new BlockDto();
        for (EventDTO event : events) {
            ItemDto item = new ItemDto();
            item.setId(event.getItemId());
            block.getItems().add(item);
        }
        itemSet.getBlocks().add(block);
        return itemSet;
    }
}
