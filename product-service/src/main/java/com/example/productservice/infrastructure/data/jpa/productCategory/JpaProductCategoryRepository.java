package com.example.productservice.infrastructure.data.jpa.productCategory;

import org.springframework.data.jpa.repository.JpaRepository;
public interface JpaProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {
}
