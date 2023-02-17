package com.example.productservice.application.categories.service;

import com.example.productservice.application.categories.entity.ProductCategory;
import com.example.productservice.application.categories.repository.ProductCategoryRepository;
import com.example.productservice.application.categories.usecase.ProductCategoryUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.productservice.application.shared.GetNullProperties.getNullPropertyNames;

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
    public ProductCategory saveProductCategory(Long id, @Valid ProductCategory productCategoryParam) {
        ProductCategory productCategory = this.getProductCategoryById(id);
        BeanUtils.copyProperties(productCategoryParam, productCategory, getNullPropertyNames(productCategoryParam));
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public boolean deleteProductCategoryById(Long id) {
        productCategoryRepository.deleteById(id);
        return true;
    }
}
