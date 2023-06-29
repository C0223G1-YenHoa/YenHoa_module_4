package com.example.shopping_cart.repository;

import com.example.shopping_cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepo extends JpaRepository<Product,Integer> {

    @Query(value = "select * from product where is_flag=false",nativeQuery = true)
    List<Product> findAllByIsFlagFalse();
}
