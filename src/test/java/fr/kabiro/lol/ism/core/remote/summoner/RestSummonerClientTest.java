package fr.kabiro.lol.ism.core.remote.summoner;

import fr.kabiro.lol.ism.RemoteTestConfig;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.summoner.dto.SummonerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = RemoteTestConfig.class)
public class RestSummonerClientTest {
    @Autowired
    private RestSummonerClient restSummonerClient;

    @Test
    public void shouldReturnASummonerByItsName() {
        Optional<SummonerDTO> summoner = restSummonerClient.getSummonerByName("Kabiro", Region.EUW1);
        assertThat(summoner).isPresent();
        assertThat(summoner.get().id).isEqualTo("aQXdQOzToJnytVq-M7PpbXR1qN6NeE9ac8ofUnSufy5O");
        assertThat(summoner.get().accountId).isEqualTo("BQ7cPkC2E6oj7eMF8WtJWDNtEgnPutnUBPibP-f0ogs");
        assertThat(summoner.get().puuid).isEqualTo("q_MN0Yn5CSbkrF47Llv2lBnsNrgblgKpXXc1lYvXHRzjo6QZPQvvarVl2ALi-mX6AkAgqv9U5wFMxA");
        assertThat(summoner.get().name).isEqualTo("Kabiro");
    }
}
