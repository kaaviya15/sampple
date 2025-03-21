package com.example.demo;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FetchWebClientService {
    private final WebClient webClient;


    public FetchWebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://dummyjson.com").build();
    }

    public Mono<List<Product>> fetchFilteredProducts(int top,double minPrice,double maxPrice){
        return webClient
                .get()
                .uri("/products")
                .retrieve()
                .bodyToMono(ListOfProducts.class)
                .map(ListOfProducts::getProducts)
                .map(products->FilteredProducts(products,top,minPrice,maxPrice))
                ;
    }

    private List<Product> FilteredProducts(List<Product> products,int top,double minPrice,double maxPrice){
        return products.stream()
                .filter(p->p.getPrice() >= minPrice && p.getPrice()<=maxPrice)
                .limit(top)
                .collect(Collectors.toList());
    }
}
