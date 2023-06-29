package com.example.shopping_cart.service;

import com.example.shopping_cart.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IProductService {

    List<Product> getProducts();
    void add(Product product);
    void delete(int id);
    Product findById(int id);
}
