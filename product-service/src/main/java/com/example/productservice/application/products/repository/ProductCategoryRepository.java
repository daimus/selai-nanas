package com.example.productservice.application.products.repository;

import com.example.productservice.application.products.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository {
    List<ProductCategory> findAll();
    ProductCategory findById(Long id);
    ProductCategory save(ProductCategory productCategory);
    boolean deleteById(Long id);
}
