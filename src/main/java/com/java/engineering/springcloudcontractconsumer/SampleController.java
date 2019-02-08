package com.java.engineering.springcloudcontractconsumer;

import com.java.engineering.springcloudcontractconsumer.model.ConfigurationPOJO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/")
public class SampleController {

    private static Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    private RestTemplate restTemplate;

    private ConfigurationPOJO myConfig;

    SampleController(RestTemplate restTemplate, ConfigurationPOJO myConfig) {
        this.restTemplate = restTemplate;
        this.myConfig = myConfig;
    }

    @GetMapping(value = "/api/endpoint1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getData() {
        final String address = myConfig.getDomain() + ":" + myConfig.getPort() + myConfig.getEndpoint();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        LOGGER.info("SampleController fron config POJO::" + myConfig.getDomain());
        ResponseEntity<String> response = restTemplate.exchange(
            address,
            HttpMethod.GET,
            new HttpEntity<String>(headers),
            String.class);

        return ResponseEntity.ok(response.getBody());

    }


}
