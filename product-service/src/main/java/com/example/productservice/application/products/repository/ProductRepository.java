package com.example.productservice.application.products.repository;

import com.example.productservice.application.products.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface ProductRepository {
    Page<Product> findAll(Pageable pageable);

    List<Product> findAll();

    Product findById(Long id);
    Product save(Product product);
    boolean deleteById(Long id);
}
