package fr.kabiro.lol.ism.core.service.impl;

import fr.kabiro.lol.ism.core.dao.SummonerDao;
import fr.kabiro.lol.ism.core.dto.SummonerDto;
import fr.kabiro.lol.ism.core.mapper.RemoteSummonerMapper;
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
    private RemoteSummonerMapper remoteSummonerMapper;

    @Autowired
    private SummonerMapper summonerMapper;

    @Override
    public Optional<SummonerDto> findByNameAndRegion(String name, Region region) {
        Optional<Summoner> summoner = summonerDao.findByNameAndRegion(name, region);
        if (summoner.isPresent()) {
            return summoner.map(summonerMapper::entityToDto);
        }
        summoner = summonerClient.getSummonerByName(name, region)
                .map(dto -> remoteSummonerMapper.dtoToEntity(dto, region));

        if (summoner.isPresent()) {
            summonerDao.save(summoner.get());
        }

        return summoner.map(summonerMapper::entityToDto);
    }
}
