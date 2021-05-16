package fr.kabiro.lol.ism.core.remote.match;

import fr.kabiro.lol.ism.RemoteTestConfig;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = RemoteTestConfig.class)
public class RestMatchClientTest {
    @Autowired
    private RestMatchClient restMatchClient;

    @Test
    public void shouldReturnAListOfMatches() {
        List<String> matchIds = restMatchClient.getRecentMatchesIdsByPuuid("q_MN0Yn5CSbkrF47Llv2lBnsNrgblgKpXXc1lYvXHRzjo6QZPQvvarVl2ALi-mX6AkAgqv9U5wFMxA", Region.EUW1);
        assertThat(matchIds).isNotEmpty();
        assertThat(matchIds).hasSize(20);
    }

    @Test
    public void shouldGetTheDetailOfAMatch() {
        MatchDto match = restMatchClient.getMatch("EUW1_5266441876", Region.EUW1);
        assertThat(match).isNotNull();
        assertThat(match.info.gameId).isEqualTo(5266441876L);
    }
}
