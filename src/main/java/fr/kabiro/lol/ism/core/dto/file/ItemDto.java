package fr.kabiro.lol.ism.core.dto.file;

public class ItemDto {
    private String id;
    private int count = 1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
