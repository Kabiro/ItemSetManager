package fr.kabiro.lol.ism.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemSetDto {
    private String title;
    private TypeDto type;
    private MapDto map;
    private ModeDto mode;
    private boolean priority = false;
    private Integer sortrank;
    private List<BlockDto> blocks = new ArrayList<>();
}
