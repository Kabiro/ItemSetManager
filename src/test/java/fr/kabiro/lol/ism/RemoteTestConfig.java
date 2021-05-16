package fr.kabiro.lol.ism;

import fr.kabiro.lol.ism.config.RiotApiConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

@TestConfiguration
@ComponentScan(basePackages = "fr.kabiro.lol.ism.core.remote")
@EnableConfigurationProperties(RiotApiConfig.class)
public class RemoteTestConfig {

}
