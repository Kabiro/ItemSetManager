package fr.kabiro.lol.ism.core.remote.staticdata;

import fr.kabiro.lol.ism.config.Profils;
import fr.kabiro.lol.ism.config.RiotApiConfig;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.RestRiotClient;
import fr.kabiro.lol.ism.core.remote.staticdata.dto.ChampionListDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.HashMap;
import java.util.Map;

@Component
@Profile(Profils.NOT_MOCK_RIOT)
public class RestStaticDataClientImpl extends RestRiotClient implements RestStaticDataClient {

    public RestStaticDataClientImpl(RiotApiConfig riotApiConfig, RestOperations restOperations) {
        super(riotApiConfig, restOperations);
    }

    @Override
    public ChampionListDto champions(Region region) {
        String url = "/lol/static-data/v3/champions";
        Map<String, Object> params = new HashMap<>();
        params.put("dataById", true);
        return doGet(url, region, false, params, ChampionListDto.class);
    }
}
