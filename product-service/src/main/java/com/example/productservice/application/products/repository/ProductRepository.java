package com.example.productservice.application.products.repository;

import com.example.productservice.application.products.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface ProductRepository {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAll(Pageable pageable, String search, Long categoryId);
    Page<Product> findAll(Pageable pageable, String search);
    Page<Product> findAll(Pageable pageable, Long categoryId);
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    boolean deleteById(Long id);

    Object existsById(Long expectedId);
}
