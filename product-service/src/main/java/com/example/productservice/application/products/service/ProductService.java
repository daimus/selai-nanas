package com.example.productservice.application.products.service;
import com.example.productservice.application.products.entity.Product;
import com.example.productservice.application.products.repository.ProductRepository;
import com.example.productservice.application.products.usecase.ProductUseCase;
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

public class ProductService implements ProductUseCase {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> getProduct(Pageable pageable, String search, Long categoryId) {
        return productRepository.findAll(pageable, search, categoryId);
    }

    @Override
    public Page<Product> getProduct(Pageable pageable, String search) {
        return productRepository.findAll(pageable, search);
    }

    @Override
    public Page<Product> getProduct(Pageable pageable, Long categoryId) {
        return productRepository.findAll(pageable, categoryId);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(@Valid Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product saveProduct(Long id, @Valid Product productParam) {
        Product product = this.getProductById(id);
        BeanUtils.copyProperties(productParam, product, getNullPropertyNames(productParam));
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProductById(Long id) {
        productRepository.deleteById(id);
        return true;
    }
    @Override
    public List<Product> getProduct(List<Long> ids) {
        return productRepository.findAll(ids);
    }
}
