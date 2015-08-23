package fr.kabiro.lol.ism.core.dto;

import java.util.ArrayList;
import java.util.List;

public class ItemSetDto {
    private Long id;
    private String title;
    private TypeDto type;
    private MapDto map;
    private ModeDto mode;
    private boolean priority = false;
    private Integer sortRank;
    private List<BlockDto> blocks = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TypeDto getType() {
        return type;
    }

    public void setType(TypeDto type) {
        this.type = type;
    }

    public MapDto getMap() {
        return map;
    }

    public void setMap(MapDto map) {
        this.map = map;
    }

    public ModeDto getMode() {
        return mode;
    }

    public void setMode(ModeDto mode) {
        this.mode = mode;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public Integer getSortRank() {
        return sortRank;
    }

    public void setSortRank(Integer sortRank) {
        this.sortRank = sortRank;
    }

    public List<BlockDto> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<BlockDto> blocks) {
        this.blocks = blocks;
    }
}
