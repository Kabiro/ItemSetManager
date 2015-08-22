package fr.kabiro.lol.ism.core.service.impl;

import fr.kabiro.lol.ism.core.dao.SummonerDao;
import fr.kabiro.lol.ism.core.mapper.SummonerMapper;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.model.Summoner;
import fr.kabiro.lol.ism.core.remote.summoner.RestSummonerClient;
import fr.kabiro.lol.ism.core.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SummonerServiceImpl implements SummonerService {

    @Autowired
    private SummonerDao summonerDao;

    @Autowired
    private RestSummonerClient summonerClient;

    @Autowired
    private SummonerMapper summonerMapper;

    @Override
    public Optional<Summoner> findByNameAndRegion(String name, Region region) {
        Optional<Summoner> summoner = summonerDao.findByNameAndRegion(name, region);
        if (summoner.isPresent()) {
            return summoner;
        }
        summoner = summonerClient.getSummonerByName(name, region)
                .map(dto -> summonerMapper.dtoToEntity(dto, region));

        if (summoner.isPresent()) {
            summonerDao.save(summoner.get());
        }

        return summoner;
    }
}
