package com.java.engineering.springcloudcontractconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MainConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
