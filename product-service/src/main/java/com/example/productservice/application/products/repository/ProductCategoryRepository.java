package com.example.productservice.application.products.repository;

import com.example.productservice.application.products.entity.Product;
import com.example.productservice.application.products.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductCategoryRepository {
    List<ProductCategory> findAll();
    Page<ProductCategory> findAll(Pageable pageable);
    ProductCategory findById(Long id);
    ProductCategory save(ProductCategory productCategory);
    boolean deleteById(Long id);
}
