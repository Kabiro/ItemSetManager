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
    private String version;

    @Autowired
    @Value("${riot.api.key}")
    private String apiKey;

    @Autowired
    @Value("${riot.api.baseUrl}")
    private String baseUrl;

    @Autowired
    protected RestOperations restOperations;


    public RestRiotClient(String version) {
        this.version = version;
    }


    protected <T> T doGet(String suffixe, Region region, Map<String, Object> params, Class<T> t) {
        UriComponentsBuilder uriBuilder = this.buildUri(baseUrl, suffixe, region, params);

        return restOperations.getForObject(uriBuilder.build().toString(), t);
    }

    protected <T> T doGet(String suffixe, Region region, Map<String, Object> params, ParameterizedTypeReference<T> parameterizedTypeReference) {
        UriComponentsBuilder uriBuilder = this.buildUri(baseUrl, suffixe, region, params);

        return restOperations.exchange(uriBuilder.build().toString(), HttpMethod.GET, null, parameterizedTypeReference).getBody();
    }

    protected UriComponentsBuilder buildUri(String baseUrl, String suffixe, Region region, Map<String, Object> params) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(region.toString().toLowerCase() + "/" + version + suffixe)
                .queryParam("api_key", apiKey);

        for (Map.Entry<String, Object> param : Utils.safe(params).entrySet()) {
            uriBuilder.queryParam(param.getKey(), param.getValue());
        }
        return uriBuilder;
    }
}
