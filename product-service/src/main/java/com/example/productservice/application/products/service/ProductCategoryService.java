package com.example.productservice.application.products.service;

import com.example.productservice.application.products.entity.ProductCategory;
import com.example.productservice.application.products.repository.ProductCategoryRepository;
import com.example.productservice.application.products.usecase.ProductCategoryUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductCategoryService implements ProductCategoryUseCase {
    private final ProductCategoryRepository productCategoryRepository;
    @Override
    public List<ProductCategory> getProductCategory() {
        return productCategoryRepository.findAll();
    }

    @Override
    public Page<ProductCategory> getProductCategory(Pageable pageable) {
        return productCategoryRepository.findAll(pageable);
    }

    @Override
    public ProductCategory getProductCategoryById(Long id) {
        return productCategoryRepository.findById(id);
    }

    @Override
    public ProductCategory saveProductCategory(@Valid ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory saveProductCategory(Long id, @Valid ProductCategory productCategory) {
        productCategory.setId(id);
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public boolean deleteProductCategoryById(Long id) {
        productCategoryRepository.deleteById(id);
        return true;
    }
}
