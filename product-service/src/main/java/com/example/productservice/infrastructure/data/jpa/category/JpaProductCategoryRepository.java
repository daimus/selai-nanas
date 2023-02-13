package com.example.productservice.infrastructure.data.jpa.category;

import org.springframework.data.jpa.repository.JpaRepository;
public interface JpaProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {
}
