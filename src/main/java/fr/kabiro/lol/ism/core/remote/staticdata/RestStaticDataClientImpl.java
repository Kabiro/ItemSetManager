package fr.kabiro.lol.ism.core.remote.staticdata;

import fr.kabiro.lol.ism.config.Profils;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.RestRiotClient;
import fr.kabiro.lol.ism.core.remote.staticdata.dto.ChampionListDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Profile(Profils.NOT_MOCK_RIOT)
public class RestStaticDataClientImpl extends RestRiotClient implements RestStaticDataClient {

    @Override
    public ChampionListDto champions(Region region) {
        String url = "/lol/static-data/v3/champions";
        Map<String, Object> params = new HashMap<>();
        params.put("dataById", true);
        return doGetV3(url, region, params, ChampionListDto.class);
    }
}
