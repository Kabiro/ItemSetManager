package fr.kabiro.lol.ism.core.mapper;

import fr.kabiro.lol.ism.core.dto.ChampionDto;
import fr.kabiro.lol.ism.core.model.Champion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChampionMapper {
    public List<ChampionDto> entityCollectionToDtoList(Collection<Champion> entities) {
        List<ChampionDto> dtos = new ArrayList<>();
        if (entities != null) {
            dtos = entities.stream().map(this::entityToDto).collect(Collectors.toList());
        }
        return dtos;
    }

    private ChampionDto entityToDto(Champion entity) {
        ChampionDto dto = new ChampionDto();
        dto.setId(entity.getId());
        dto.setKey(entity.getKey());
        dto.setName(entity.getName());
        dto.setTitle(entity.getTitle());
        return dto;
    }
}
