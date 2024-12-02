package com.example.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${product_module_url}")
    String PRODUCT_MODULE_URL;

    @Bean
    public RestClient restTemplate() {
        return RestClient.builder()
                .baseUrl(PRODUCT_MODULE_URL)
                .build();
    }
}