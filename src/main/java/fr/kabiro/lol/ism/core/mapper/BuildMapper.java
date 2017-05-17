package fr.kabiro.lol.ism.core.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kabiro.lol.ism.core.dto.BuildDto;
import fr.kabiro.lol.ism.core.dto.ItemSetDto;
import fr.kabiro.lol.ism.core.model.Build;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildMapper {

    private ChampionMapper championMapper;

    private ObjectMapper objectMapper;

    public BuildMapper(ChampionMapper championMapper, ObjectMapper objectMapper) {
        this.championMapper = championMapper;
        this.objectMapper = objectMapper;
    }

    public List<BuildDto> entityCollectionToDtoList(Collection<Build> builds) {
        List<BuildDto> dtos = new ArrayList<>();
        if (builds != null) {
            dtos = builds.stream().map(this::entityToDto).collect(Collectors.toList());
        }
        return dtos;
    }

    public BuildDto entityToDto(Build build) {
        BuildDto dto = new BuildDto();
        dto.setId(build.getId());
        dto.setChampions(championMapper.entityCollectionToDtoList(build.getChampions()));
        try {
            dto.setItemSet(objectMapper.readValue(build.getJson(), ItemSetDto.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }
}
