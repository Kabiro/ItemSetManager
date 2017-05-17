package fr.kabiro.lol.ism.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kabiro.lol.ism.core.dao.BuildDao;
import fr.kabiro.lol.ism.core.dao.ChampionDao;
import fr.kabiro.lol.ism.core.dao.SummonerDao;
import fr.kabiro.lol.ism.core.model.Build;
import fr.kabiro.lol.ism.core.model.Champion;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.model.Summoner;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class TestDataConfig {

    private SummonerDao summonerDao;

    private BuildDao buildDao;

    private ChampionDao championDao;

    private ObjectMapper objectMapper;

    public TestDataConfig(SummonerDao summonerDao, BuildDao buildDao, ChampionDao championDao, ObjectMapper objectMapper) {
        this.summonerDao = summonerDao;
        this.buildDao = buildDao;
        this.championDao = championDao;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void generateTestDatas() throws IOException {
        if (!summonerDao.findById(149869L).isPresent()) {
            Champion[] champions = objectMapper.readValue(new ClassPathResource("champions.json").getURL(), Champion[].class);
            championDao.saveAll(Arrays.asList(champions));

            Summoner kabiro = Summoner.builder().name("Kabiro").riotId(149869L).accountId(155605L).region(Region.EUW1).build();

            InputStream itemSetIS = new ClassPathResource("itemSet.json").getInputStream();
            String itemSet = IOUtils.toString(itemSetIS);
            IOUtils.closeQuietly(itemSetIS);

            Build b1 = Build.builder().json(itemSet).summoner(kabiro).champions(new HashSet<>(Arrays.asList(champions))).build();
            Build b2 = Build.builder().json(itemSet).summoner(kabiro).champions(new HashSet<>(Arrays.asList(champions))).build();
            Build b3 = Build.builder().json(itemSet).summoner(kabiro).build();

            summonerDao.save(kabiro);
            buildDao.saveAll(Arrays.asList(b1, b2, b3));

        }
    }
}
