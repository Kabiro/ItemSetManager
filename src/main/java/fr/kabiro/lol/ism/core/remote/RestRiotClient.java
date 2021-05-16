package fr.kabiro.lol.ism.core.remote;

import fr.kabiro.lol.ism.Utils;
import fr.kabiro.lol.ism.config.RiotApiConfig;
import fr.kabiro.lol.ism.core.model.Region;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
public abstract class RestRiotClient {
    private RiotApiConfig riotApiConfig;

    private RestOperations restOperations;

    public RestRiotClient(RiotApiConfig riotApiConfig, RestOperations restOperations) {
        this.riotApiConfig = riotApiConfig;
        this.restOperations = restOperations;
    }

    protected <T> T doGet(String path, Region region, Map<String, Object> params, Class<T> t) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(riotApiConfig.getHost().replace("{{region}}", region.name().toLowerCase()))
                .path(path)
                .queryParam("api_key", riotApiConfig.getKey());

        for (Map.Entry<String, Object> param : Utils.safe(params).entrySet()) {
            uriBuilder.queryParam(param.getKey(), param.getValue());
        }

        return restOperations.getForObject(uriBuilder.build().toString(), t);
    }
}
