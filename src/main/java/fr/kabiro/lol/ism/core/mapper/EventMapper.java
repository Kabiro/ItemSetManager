package fr.kabiro.lol.ism.core.mapper;

import fr.kabiro.lol.ism.core.dto.*;
import fr.kabiro.lol.ism.core.remote.match.dto.EventDTO;
import fr.kabiro.lol.ism.core.remote.match.dto.EventTypeDTO;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;

@Component
public class EventMapper {
    private PeriodFormatter FORMATTER;

    public EventMapper(){
         FORMATTER = new PeriodFormatterBuilder()
                .printZeroAlways()
                .appendMinutes()
                .appendSeparator(":")
                .minimumPrintedDigits(2)
                .appendSeconds()
                .toFormatter();
    }

    public ItemSetDto eventsToItemSet(Collection<EventDTO> events) {
        ItemSetDto itemSet = new ItemSetDto();
        itemSet.setTitle("The name of the page");
        itemSet.setType(TypeDto.custom);
        itemSet.setMode(ModeDto.any);
        itemSet.setMap(MapDto.any);

        BlockDto block = new BlockDto();
        block.setType("Starter");
        itemSet.getBlocks().add(block);
        Long lastBackTimestamp = 0L;
        for (EventDTO event : events) {
            if (event.getEventType() == EventTypeDTO.ITEM_PURCHASED && isNotUndone(event, events)){
                if (event.getTimestamp() - lastBackTimestamp > 100_000L) {  //Backs last up to 100 seconds
                    lastBackTimestamp = event.getTimestamp();
                    block = new BlockDto();
                    itemSet.getBlocks().add(block);
                    Period period = Duration.millis(lastBackTimestamp).toPeriod();
                    block.setType("Back at " + FORMATTER.print(period));
                }
            }
            ItemDto item = new ItemDto();
            item.setId(event.getItemId());
            block.getItems().add(item);
        }
        return itemSet;
    }

    public boolean isNotUndone(EventDTO event, Collection<EventDTO> events){
        return events.stream()
                .filter(other -> other.getTimestamp() > event.getTimestamp())
                .filter(other -> Objects.equals(other.getItemId(), event.getItemId()))
                .filter(other -> undone(other) || soldRapidly(event, other))
                .count() == 0;
    }

    private boolean soldRapidly(EventDTO event, EventDTO other) {
        return other.getEventType() == EventTypeDTO.ITEM_SOLD && other.getTimestamp() - event.getTimestamp() < 5000;
    }

    private boolean undone(EventDTO other) {
        return other.getEventType() == EventTypeDTO.ITEM_UNDO;
    }
}
