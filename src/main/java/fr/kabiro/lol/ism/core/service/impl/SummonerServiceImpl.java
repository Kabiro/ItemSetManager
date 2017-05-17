package fr.kabiro.lol.ism.core.service.impl;

import fr.kabiro.lol.ism.core.dao.SummonerDao;
import fr.kabiro.lol.ism.core.dto.SummonerDto;
import fr.kabiro.lol.ism.core.mapper.RemoteSummonerMapper;
import fr.kabiro.lol.ism.core.mapper.SummonerMapper;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.model.Summoner;
import fr.kabiro.lol.ism.core.remote.summoner.RestSummonerClient;
import fr.kabiro.lol.ism.core.service.SummonerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SummonerServiceImpl implements SummonerService {

    private SummonerDao summonerDao;

    private RestSummonerClient summonerClient;

    private RemoteSummonerMapper remoteSummonerMapper;

    private SummonerMapper summonerMapper;

    public SummonerServiceImpl(SummonerDao summonerDao, RestSummonerClient summonerClient, RemoteSummonerMapper remoteSummonerMapper, SummonerMapper summonerMapper) {
        this.summonerDao = summonerDao;
        this.summonerClient = summonerClient;
        this.remoteSummonerMapper = remoteSummonerMapper;
        this.summonerMapper = summonerMapper;
    }

    @Override
    public Optional<SummonerDto> findByNameAndRegion(String name, Region region) {
        Optional<Summoner> summoner = summonerDao.findByNameAndRegion(name, region);
        if (summoner.isPresent()) {
            return summoner.map(summonerMapper::entityToDto);
        }
        summoner = summonerClient.getSummonerByName(name, region)
                .map(dto -> remoteSummonerMapper.dtoToEntity(dto, region));

        summoner.ifPresent(summoner1 -> summonerDao.save(summoner1));

        return summoner.map(summonerMapper::entityToDto);
    }
}
