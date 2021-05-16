package fr.kabiro.lol.ism.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChampionDto {
    private String key;
    private String name;
    private String title;
    private Long id;
}
