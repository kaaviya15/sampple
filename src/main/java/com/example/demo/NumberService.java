package com.example.demo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class NumberService {

    public final WebClient webClient;

    public NumberService(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("http://www.randomnumberapi.com/api/v1.0").build();
    }

    public List<Integer> fetchRandomNumber(){
        return webClient
                .get()
                .uri("/random")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Integer>>() {})
               .block();
    }
}
