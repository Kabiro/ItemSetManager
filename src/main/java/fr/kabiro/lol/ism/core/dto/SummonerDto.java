package fr.kabiro.lol.ism.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummonerDto {
    private Long riotId;
    private Long accountId;
    private String name;
    private RegionDto region;
    private Integer summonerIcon;
}
