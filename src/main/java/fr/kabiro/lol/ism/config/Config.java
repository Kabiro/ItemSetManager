package fr.kabiro.lol.ism.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kabiro.lol.ism.core.model.Region;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public Region defaultRegion(){
        return Region.EUW;
    }

}
