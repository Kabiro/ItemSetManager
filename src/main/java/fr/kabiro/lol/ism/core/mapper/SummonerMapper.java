package fr.kabiro.lol.ism.core.mapper;

import fr.kabiro.lol.ism.core.dto.RegionDto;
import fr.kabiro.lol.ism.core.dto.SummonerDto;
import fr.kabiro.lol.ism.core.model.Summoner;
import org.springframework.stereotype.Component;

@Component
public class SummonerMapper {

    public SummonerDto entityToDto(Summoner entity){
        SummonerDto dto = new SummonerDto();
        dto.setRiotId(entity.getRiotId());
        dto.setAccountId(entity.getAccountId());
        dto.setName(entity.getName());
        dto.setRegion(RegionDto.valueOf(entity.getRegion().name()));
        dto.setSummonerIcon(entity.getSummonerIcon());
        return dto;
    }
}
