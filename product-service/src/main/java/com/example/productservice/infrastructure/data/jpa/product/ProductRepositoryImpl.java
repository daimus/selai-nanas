package com.example.productservice.infrastructure.data.jpa.product;

import com.example.productservice.application.products.entity.Product;
import com.example.productservice.application.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final JpaProductRepository jpaProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        Page<ProductEntity> productEntities = jpaProductRepository.findAll(pageable);
        List<Product> products = new ArrayList<>();
        for (ProductEntity productEntity: productEntities.getContent()){
            Product product = new Product();
            BeanUtils.copyProperties(productEntity, product);
            products.add(product);
        }
        return new PageImpl<>(products, pageable, productEntities.getTotalElements());
    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> productEntities = (List<ProductEntity>) jpaProductRepository.findAll();
        List<Product> products = new ArrayList<>();
        for (ProductEntity productEntity: productEntities){
            Product product = new Product();
            BeanUtils.copyProperties(productEntity, product);
            products.add(product);
        }
        return products;
    }


    @Override
    public Product findById(Long id) {
        Optional<ProductEntity> productEntities = jpaProductRepository.findById(id);
        if (productEntities.isEmpty()){
            throw new NoSuchElementException();
        }
        Product product = new Product();
        BeanUtils.copyProperties(productEntities.get(), product);
        return product;
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntities = new ProductEntity();
        BeanUtils.copyProperties(product, productEntities);
        productEntities = jpaProductRepository.save(productEntities);
        BeanUtils.copyProperties(productEntities, product);
        return product;
    }

    @Override
    public boolean deleteById(Long id) {
        jpaProductRepository.deleteById(id);
        return true;
    }

}
