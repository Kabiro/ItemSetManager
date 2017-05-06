package fr.kabiro.lol.ism.core.mapper;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.model.Summoner;
import fr.kabiro.lol.ism.core.remote.summoner.dto.SummonerDTO;
import org.springframework.stereotype.Component;

@Component
public class RemoteSummonerMapper {
    public Summoner dtoToEntity(SummonerDTO summonerDTO, Region region) {
        return Summoner.builder()
                .riotId(summonerDTO.id)
                .accountId(summonerDTO.accountId)
                .name(summonerDTO.name)
                .region(region)
                .summonerIcon(summonerDTO.profileIconId)
                .build();
    }
}
