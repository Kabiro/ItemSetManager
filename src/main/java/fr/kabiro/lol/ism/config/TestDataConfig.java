package fr.kabiro.lol.ism.config;

import fr.kabiro.lol.ism.core.dao.BuildDao;
import fr.kabiro.lol.ism.core.dao.SummonerDao;
import fr.kabiro.lol.ism.core.model.Build;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.model.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
public class TestDataConfig {

    @Autowired
    private SummonerDao summonerDao;

    @Autowired
    private BuildDao buildDao;

    @PostConstruct
    public void generateTestDatas(){
        if (summonerDao.findOne(149869L) == null) {
            Summoner kabiro = Summoner.builder().name("Kabiro").riotId(149869L).region(Region.EUW).build();

            Build b1 = Build.builder().json("{title:'build1'}").summoner(kabiro).build();
            Build b2 = Build.builder().json("{title:'build2'}").summoner(kabiro).build();
            Build b3 = Build.builder().json("{title:'build3'}").summoner(kabiro).build();

            summonerDao.save(kabiro);
            buildDao.save(Arrays.asList(b1, b2, b3));
        }
    }
}
