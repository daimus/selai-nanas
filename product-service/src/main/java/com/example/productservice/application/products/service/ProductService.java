package com.example.productservice.application.products.service;
import com.example.productservice.application.products.repository.ProductRepository;
import com.example.productservice.application.products.usecase.ProductUseCase;
import com.example.productservice.application.products.entity.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class ProductService implements ProductUseCase {
    private final ProductRepository productRepository;
    @Override
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(@Valid Product user) {
        return productRepository.save(user);
    }

    @Override
    public Product saveProduct(Long id, @Valid Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProductById(Long id) {
        productRepository.deleteById(id);
        return true;
    }
}
