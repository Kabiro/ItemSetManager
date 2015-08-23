package fr.kabiro.lol.ism.core.mapper;

import fr.kabiro.lol.ism.core.dto.ItemSetDto;
import fr.kabiro.lol.ism.core.model.Build;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class BuildMapper {

    public List<ItemSetDto> entityCollectionToDtoList(Collection<Build> builds) {
        List<ItemSetDto> dtos = new ArrayList<>();
        if (builds != null) {
            for (Build build : builds) {
                dtos.add(this.entityToDto(build));
            }
        }
        return dtos;
    }

    public ItemSetDto entityToDto(Build build) {
        ItemSetDto dto = new ItemSetDto();
        dto.setId(build.getId());
        return dto;
    }
}
