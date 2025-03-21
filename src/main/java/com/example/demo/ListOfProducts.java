package com.example.demo;

import lombok.Data;

import java.util.List;


@Data
public class ListOfProducts {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
