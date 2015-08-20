package fr.kabiro.lol.ism.core.service.impl;

import fr.kabiro.lol.ism.core.dao.BuildDao;
import fr.kabiro.lol.ism.core.dto.file.ItemSetDto;
import fr.kabiro.lol.ism.core.mapper.BuildMapper;
import fr.kabiro.lol.ism.core.model.Build;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.service.ItemSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemSetServiceImpl implements ItemSetService {

    @Autowired
    private BuildDao buildDao;

    @Autowired
    private BuildMapper buildMapper;

    @Override
    public List<ItemSetDto> findItemsSetByUser(String name, Region region) {
        List<Build> builds = buildDao.findBuildsBySummonerNameAndRegion(name, region);
        return buildMapper.entityCollectionToDtoList(builds);
    }
}
