package fr.kabiro.lol.ism.core.remote.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kabiro.lol.ism.config.Profils;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.game.RestGamesClient;
import fr.kabiro.lol.ism.core.remote.game.dto.RecentGamesDTO;
import fr.kabiro.lol.ism.core.remote.match.RestMatchClient;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDetailDTO;
import fr.kabiro.lol.ism.core.remote.staticdata.RestStaticDataClient;
import fr.kabiro.lol.ism.core.remote.staticdata.dto.ChampionListDto;
import fr.kabiro.lol.ism.core.remote.summoner.RestSummonerClient;
import fr.kabiro.lol.ism.core.remote.summoner.dto.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Component
@Profile(Profils.MOCK_RIOT)
public class RestClientMock implements RestGamesClient, RestMatchClient, RestStaticDataClient, RestSummonerClient {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public RecentGamesDTO getRecentGamesBySummonerId(Long riotId, Region region) {
        try {
            return objectMapper.readValue(new ClassPathResource("mocks/recentGames.json").getFile(), RecentGamesDTO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MatchDetailDTO getMatchDetails(Long matchId, Region region, boolean includeTimeline) {
        try {
            return objectMapper.readValue(new ClassPathResource("mocks/gameDetails.json").getFile(), MatchDetailDTO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ChampionListDto champions(Region region) {
        try {
            return objectMapper.readValue(new ClassPathResource("mocks/championsMap.json").getFile(), ChampionListDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<SummonerDTO> getSummonersByNames(Collection<String> names, Region region) {
        return null;
    }

    @Override
    public Optional<SummonerDTO> getSummonerByName(String name, Region region) {
        return null;
    }

    @Override
    public Map<Long, SummonerDTO> getSummonersByRiotIds(Collection<Long> riotIds, Region region) {
        return null;
    }

    @Override
    public Optional<SummonerDTO> getSummonerByRiotId(Long id, Region region) {
        return null;
    }
}
