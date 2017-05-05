package fr.kabiro.lol.ism.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariDataSource;
import fr.kabiro.lol.ism.core.model.Region;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

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

    @Bean
    public DataSource dataSource(Environment environment) throws URISyntaxException, ClassNotFoundException {
        String herokuUrl = environment.getProperty("DATABASE_URL");
        String springDatasourceUrl = environment.getProperty("spring.datasource.url");
        HikariDataSource ds = new HikariDataSource();

        if (!StringUtils.isEmpty(herokuUrl)){                   //Heroku postgres database
            URI uri = new URI(herokuUrl);
            String username = uri.getUserInfo().split(":")[0];
            String password = uri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + uri.getHost() + ':' + uri.getPort() + uri.getPath();

            ds.setJdbcUrl(dbUrl);
            ds.setUsername(username);
            ds.setPassword(password);
        }
        else if (!StringUtils.isEmpty(springDatasourceUrl)){    //Use standard config
            ds.setJdbcUrl(springDatasourceUrl);
            ds.setUsername(environment.getProperty("spring.datasource.username"));
            ds.setPassword(environment.getProperty("spring.datasource.password"));
        }
        else{                                                   //Fallback to h2
            ds.setJdbcUrl("jdbc:h2:mem:DB_CLOSE_ON_EXIT=FALSE");
        }
        return ds;
    }
}
