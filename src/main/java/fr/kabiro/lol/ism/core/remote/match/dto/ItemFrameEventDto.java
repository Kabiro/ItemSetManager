package fr.kabiro.lol.ism.core.remote.match.dto;

public class ItemFrameEventDto extends FrameEventDto {
    public Integer itemId;
    public Integer participantId;

    public boolean isPurchaseEvent() {
        return "ITEM_PURCHASED".equals(this.type);
    }
    public boolean isDestroyEvent() {
        return "ITEM_DESTROYED".equals(this.type);
    }
}
