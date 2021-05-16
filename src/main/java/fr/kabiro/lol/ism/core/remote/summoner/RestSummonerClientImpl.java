package fr.kabiro.lol.ism.core.remote.summoner;

import fr.kabiro.lol.ism.config.Profils;
import fr.kabiro.lol.ism.config.RiotApiConfig;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.RestRiotClient;
import fr.kabiro.lol.ism.core.remote.summoner.dto.SummonerDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.Collections;
import java.util.Optional;

@Component
@Profile(Profils.NOT_MOCK_RIOT)
public class RestSummonerClientImpl extends RestRiotClient implements RestSummonerClient {

    public RestSummonerClientImpl(RiotApiConfig riotApiConfig, RestOperations restOperations) {
        super(riotApiConfig, restOperations);
    }

    @Override
    public Optional<SummonerDTO> getSummonerByName(String name, Region region) {
        String url = "/lol/summoner/v4/summoners/by-name/" + name;
        return Optional.of(doGet(url, region, false, Collections.emptyMap(), SummonerDTO.class));
    }
}
