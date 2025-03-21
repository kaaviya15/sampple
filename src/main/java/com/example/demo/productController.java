package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/random")
public class productController {

    @Autowired
    private NumberService numberService;
//    private FetchWebClientService productService;

//    @GetMapping
//    public Mono<List<Product>> getFilteredProducts(@RequestParam int top,@RequestParam double minPrice,@RequestParam double maxPrice){
//        return productService.fetchFilteredProducts(top, minPrice, maxPrice);
//    }

    @GetMapping
    public List<Integer> getRandomNumber(){
        return numberService.fetchRandomNumber();
    }
}
