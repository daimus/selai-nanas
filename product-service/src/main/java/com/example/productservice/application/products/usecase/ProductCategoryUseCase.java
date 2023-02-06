package com.example.productservice.application.products.usecase;
import com.example.productservice.application.products.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryUseCase {
    List<ProductCategory> getProductCategory();
    ProductCategory getProductCategoryById(Long id);
    ProductCategory saveProductCategory(ProductCategory productCategory);
    ProductCategory saveProductCategory(Long id, ProductCategory productCategory);
    boolean deleteProductCategoryById(Long id);
}
