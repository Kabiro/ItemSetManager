package fr.kabiro.lol.ism.core.remote;

import fr.kabiro.lol.ism.Utils;
import fr.kabiro.lol.ism.core.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
public abstract class RestRiotClient {
    @Autowired
    @Value("${riot.api.key}")
    private String apiKey;

    @Autowired
    @Value("${riot.api.host}")
    private String host;

    @Autowired
    private RestOperations restOperations;

    protected <T> T doGetV3(String path, Region region, Map<String, Object> params, Class<T> t) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(host.replace("{{region}}", region.getV3().name().toLowerCase()))
                .path(path)
                .queryParam("api_key", apiKey);

        for (Map.Entry<String, Object> param : Utils.safe(params).entrySet()) {
            uriBuilder.queryParam(param.getKey(), param.getValue());
        }

        return restOperations.getForObject(uriBuilder.build().toString(), t);
    }
}
