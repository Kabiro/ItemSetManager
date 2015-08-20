package fr.kabiro.lol.ism.core.dto.file;

import java.util.ArrayList;
import java.util.List;

public class ItemSetDto {
    private Integer id;
    private String title;
    private TypeDto type;
    private MapDto map;
    private ModeDto mode;
    private boolean priority = false;
    private Integer sortRank;
    private List<BlockDto> blocks = new ArrayList<>();
}
