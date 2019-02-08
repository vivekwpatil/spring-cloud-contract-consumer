package com.java.engineering.springcloudcontractconsumer.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "outserver.api")
public class ConfigurationPOJO {

    private String domain;
    private String port;
    private String endpoint;

    public String getDomain() {
        return domain;
    }

    public String getPort() {
        return port;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
