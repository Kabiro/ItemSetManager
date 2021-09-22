package fr.kabiro.lol.ism.core.remote.match.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        defaultImpl = FrameEventDto.class,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ItemFrameEventDto.class, name = "ITEM_PURCHASED"),
        @JsonSubTypes.Type(value = ItemFrameEventDto.class, name = "ITEM_DESTROYED")
})
public class FrameEventDto {
    public Long timestamp;
    public String type;
}
