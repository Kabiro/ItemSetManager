package fr.kabiro.lol.ism.dto.file;

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
}
