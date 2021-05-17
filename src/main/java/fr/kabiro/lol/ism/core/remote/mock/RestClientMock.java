package fr.kabiro.lol.ism.core.remote.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kabiro.lol.ism.config.Profils;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.match.RestMatchClient;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDto;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchTimelineDto;
import fr.kabiro.lol.ism.core.remote.summoner.RestSummonerClient;
import fr.kabiro.lol.ism.core.remote.summoner.dto.SummonerDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@Profile(Profils.MOCK_RIOT)
public class RestClientMock implements RestMatchClient, RestSummonerClient {

    private ObjectMapper objectMapper;

    public RestClientMock(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Override
    public List<String> getRecentMatchesIdsByPuuid(String accountId, Region region) {
        try {
            return objectMapper.readValue(new ClassPathResource("mocks/recentMatchLists.json").getURL(), List.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MatchTimelineDto getTimeline(Long matchId, Region region) {
        try {
            return objectMapper.readValue(new ClassPathResource("mocks/matchTimeline.json").getURL(), MatchTimelineDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MatchDto getMatch(String matchId, Region region) {
        try {
            return objectMapper.readValue(new ClassPathResource("mocks/match.json").getURL(), MatchDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<SummonerDTO> getSummonerByName(String name, Region region) {
        try {
            return Optional.of(objectMapper.readValue(new ClassPathResource("mocks/summonerByName.json").getURL(), SummonerDTO.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
