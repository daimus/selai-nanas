package com.example.productservice.application.products.repository;

import com.example.productservice.application.products.entity.Product;

import java.util.List;
public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    boolean deleteById(Long id);
}
