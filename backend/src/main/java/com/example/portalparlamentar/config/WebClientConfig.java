package com.example.portalparlamentar.config;

import com.example.portalparlamentar.exception.WebClientErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder()
                .filter(WebClientErrorHandler.handleErrors());
    }

}
