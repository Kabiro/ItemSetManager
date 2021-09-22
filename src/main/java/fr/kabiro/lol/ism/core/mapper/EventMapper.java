package fr.kabiro.lol.ism.core.mapper;

import fr.kabiro.lol.ism.core.dto.*;
import fr.kabiro.lol.ism.core.remote.match.dto.ItemFrameEventDto;
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

    public ItemSetDto eventsToItemSet(Collection<ItemFrameEventDto> events) {
        ItemSetDto itemSet = new ItemSetDto();
        itemSet.setTitle("The name of the page");
        itemSet.setType(TypeDto.custom);
        itemSet.setMode(ModeDto.any);
        itemSet.setMap(MapDto.any);

        BlockDto block = new BlockDto();
        block.setType("Starter");
        itemSet.getBlocks().add(block);
        Long lastBackTimestamp = 0L;
        for (ItemFrameEventDto event : events) {
            if (event.isPurchaseEvent() && isNotUndone(event, events)){
                if (event.timestamp - lastBackTimestamp > 100_000L) {  //Backs last up to 100 seconds
                    lastBackTimestamp = event.timestamp;
                    block = new BlockDto();
                    itemSet.getBlocks().add(block);
                    Period period = Duration.millis(lastBackTimestamp).toPeriod();
                    block.setType("Back at " + FORMATTER.print(period));
                }
                ItemDto item = new ItemDto();
                item.setId(event.itemId);
                block.getItems().add(item);
            }
        }
        return itemSet;
    }

    private boolean isNotUndone(ItemFrameEventDto event, Collection<ItemFrameEventDto> events){
        return events.stream()
                .filter(other -> other.timestamp > event.timestamp)
                .filter(other -> Objects.equals(other.itemId, event.itemId))
                .noneMatch(other -> sold(event, other));
    }

    private boolean sold(ItemFrameEventDto event, ItemFrameEventDto other) {
        return other.isDestroyEvent() && other.timestamp - event.timestamp < 15000;
    }

}
