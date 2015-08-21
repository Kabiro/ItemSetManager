package fr.kabiro.lol.ism.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kabiro.lol.ism.core.dao.BuildDao;
import fr.kabiro.lol.ism.core.dao.ChampionDao;
import fr.kabiro.lol.ism.core.dao.SummonerDao;
import fr.kabiro.lol.ism.core.model.Build;
import fr.kabiro.lol.ism.core.model.Champion;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.model.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class TestDataConfig {

    @Autowired
    private SummonerDao summonerDao;

    @Autowired
    private BuildDao buildDao;

    @Autowired
    private ChampionDao championDao;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void generateTestDatas() throws IOException {
        if (summonerDao.findOne(149869L) == null) {
            Champion[] champions = objectMapper.readValue(new ClassPathResource("champions.json").getFile(), Champion[].class);
            championDao.save(Arrays.asList(champions));

            Summoner kabiro = Summoner.builder().name("Kabiro").riotId(149869L).region(Region.EUW).build();

            Build b1 = Build.builder().json("{title:'build1'}").summoner(kabiro).champions(new HashSet<>(Arrays.asList(champions))).build();
            Build b2 = Build.builder().json("{title:'build2'}").summoner(kabiro).champions(new HashSet<>(Arrays.asList(champions))).build();
            Build b3 = Build.builder().json("{title:'build3'}").summoner(kabiro).build();

            summonerDao.save(kabiro);
            buildDao.save(Arrays.asList(b1, b2, b3));

        }
    }
}
