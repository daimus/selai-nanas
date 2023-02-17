package com.example.productservice.application.products.usecase;
import com.example.productservice.application.products.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductUseCase {
    List<Product> getProduct();
    Page<Product> getProduct(Pageable pageable);
    Page<Product> getProduct(Pageable pageable, String search, Long categoryId);
    Page<Product> getProduct(Pageable pageable, String search);
    Page<Product> getProduct(Pageable pageable, Long categoryId);
    Product getProductById(Long id);
    Product saveProduct(Product product);
    Product saveProduct(Long id, Product product);
    boolean deleteProductById(Long id);
    List<Product> getProduct(List<Long> ids);
}
