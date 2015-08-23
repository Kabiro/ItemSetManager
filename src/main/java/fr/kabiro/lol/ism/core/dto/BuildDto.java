package fr.kabiro.lol.ism.core.dto;

import java.util.List;

public class BuildDto {
    private Long id;
    private List<ChampionDto> champions;
    private ItemSetDto itemSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ChampionDto> getChampions() {
        return champions;
    }

    public void setChampions(List<ChampionDto> champions) {
        this.champions = champions;
    }

    public ItemSetDto getItemSet() {
        return itemSet;
    }

    public void setItemSet(ItemSetDto itemSet) {
        this.itemSet = itemSet;
    }
}
