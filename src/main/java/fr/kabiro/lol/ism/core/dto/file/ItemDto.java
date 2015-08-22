package fr.kabiro.lol.ism.core.dto.file;

public class ItemDto {
    private Integer id;
    private int count = 1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
