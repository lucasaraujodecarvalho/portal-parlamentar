package com.example.portalparlamentar.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ApiConfig {

    @Value("${camara.api.base-url}")
    private String camaraBaseUrl;

    @Value("${senado.api.base-url}")
    private String senadoBaseUrl;

    @Bean
    public String camaraBaseUrl() {
        return camaraBaseUrl;
    }

    @Bean
    public String senadoBaseUrl() {
        return senadoBaseUrl;
    }

}
