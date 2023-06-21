package com.example.product_management.repository;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getProducts();
    void create(Product product);
    void update(Product product);
    void delete(int id);
    Product detail(int id);
    List<Product> search(String name);
    Product findByID(int id);
}
