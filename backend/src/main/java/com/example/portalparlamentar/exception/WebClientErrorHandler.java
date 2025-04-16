package com.example.portalparlamentar.exception;

import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

public class WebClientErrorHandler {

    private WebClientErrorHandler() {}

    public static ExchangeFilterFunction handleErrors() {
        return ExchangeFilterFunction.ofResponseProcessor(WebClientErrorHandler::handleResponse);
    }

    private static Mono<ClientResponse> handleResponse(ClientResponse response) {
        if (response.statusCode().is4xxClientError() || response.statusCode().is5xxServerError()) {
            return response.bodyToMono(String.class)
                    .flatMap(body -> Mono.error(new ExternalApiException("Erro da API externa: " + body)));
        }
        return Mono.just(response);
    }

}
