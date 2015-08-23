package fr.kabiro.lol.ism.core.dto;

import java.util.ArrayList;
import java.util.List;

public class BlockDto {
    private String type;
    private boolean recMath = false;
    private int minSummonerLevel =  -1;
    private int maxSummonerLevel = -1;
    private String showIfSummonerSpell;
    private String hideIfSummonerSpell;
    private List<ItemDto> items = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRecMath() {
        return recMath;
    }

    public void setRecMath(boolean recMath) {
        this.recMath = recMath;
    }

    public int getMinSummonerLevel() {
        return minSummonerLevel;
    }

    public void setMinSummonerLevel(int minSummonerLevel) {
        this.minSummonerLevel = minSummonerLevel;
    }

    public int getMaxSummonerLevel() {
        return maxSummonerLevel;
    }

    public void setMaxSummonerLevel(int maxSummonerLevel) {
        this.maxSummonerLevel = maxSummonerLevel;
    }

    public String getShowIfSummonerSpell() {
        return showIfSummonerSpell;
    }

    public void setShowIfSummonerSpell(String showIfSummonerSpell) {
        this.showIfSummonerSpell = showIfSummonerSpell;
    }

    public String getHideIfSummonerSpell() {
        return hideIfSummonerSpell;
    }

    public void setHideIfSummonerSpell(String hideIfSummonerSpell) {
        this.hideIfSummonerSpell = hideIfSummonerSpell;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
