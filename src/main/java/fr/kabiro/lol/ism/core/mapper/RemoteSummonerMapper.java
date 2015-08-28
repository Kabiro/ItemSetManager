package fr.kabiro.lol.ism.core.mapper;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.model.Summoner;
import fr.kabiro.lol.ism.core.remote.summoner.dto.SummonerDTO;
import org.springframework.stereotype.Component;

@Component
public class RemoteSummonerMapper {
    public Summoner dtoToEntity(SummonerDTO summonerDTO, Region region) {
        return Summoner.builder()
                .name(summonerDTO.getName())
                .riotId(summonerDTO.getId())
                .region(region)
                .summonerIcon(summonerDTO.getProfileIconId())
                .build();
    }
}
