package fr.kabiro.lol.ism.core.model.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TeamPlayer {
    private Integer championId;
    private String championName;
}
