package com.example.productservice.application.products.usecase;
import com.example.productservice.application.products.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductUseCase {
    List<Product> getProduct();

    Page<Product> getProduct(Integer page, Integer size);

    Product getProductById(Long id);
    Product saveProduct(Product product);
    Product saveProduct(Long id, Product product);
    boolean deleteProductById(Long id);
}
