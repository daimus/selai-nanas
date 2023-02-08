package com.example.productservice.application.products.usecase;
import com.example.productservice.application.products.entity.ProductCategory;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductCategoryUseCase {
    List<ProductCategory> getProductCategory();

    Page<ProductCategory> getProductCategory(Integer page, Integer size);

    ProductCategory getProductCategoryById(Long id);
    ProductCategory saveProductCategory(ProductCategory productCategory);
    ProductCategory saveProductCategory(Long id, ProductCategory productCategory);
    boolean deleteProductCategoryById(Long id);
}
