package fr.kabiro.lol.ism.core.remote.staticdata;

import fr.kabiro.lol.ism.config.Profils;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.RestRiotClient;
import fr.kabiro.lol.ism.core.remote.staticdata.dto.ChampionListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import java.util.HashMap;
import java.util.Map;

@Component
@Profile(Profils.NOT_MOCK_RIOT)
public class RestStaticDataClientImpl extends RestRiotClient implements RestStaticDataClient {
    private final static String VERSION = "v1.2";

    @Autowired
    @Value("${riot.api.staticData.baseUrl}")
    private String staticDataBaseUrl;

    public RestStaticDataClientImpl() {
        super(VERSION);
    }

    @Override
    public ChampionListDto champions(Region region) {
        Map<String, Object> params = new HashMap<>();
        params.put("dataById", true);
        UriComponents uri = super.buildUri(staticDataBaseUrl, "/champion", region, params).build();
        return restOperations.getForEntity(uri.toString(), ChampionListDto.class).getBody();
    }
}
