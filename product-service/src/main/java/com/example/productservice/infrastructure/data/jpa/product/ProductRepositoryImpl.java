package com.example.productservice.infrastructure.data.jpa.product;

import com.example.productservice.application.products.entity.Product;
import com.example.productservice.application.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final JpaProductRepository jpaProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        Page<ProductEntity> productEntities = jpaProductRepository.findAll(pageable);
        return this.castProductEntity(productEntities, pageable);
    }

    @Override
    public Page<Product> findAll(Pageable pageable, String search, Long categoryId) {
        Page<ProductEntity> productEntities = jpaProductRepository.getProductBySearchQueryAndCategory(search, categoryId, pageable);
        return this.castProductEntity(productEntities, pageable);
    }

    @Override
    public Page<Product> findAll(Pageable pageable, String search) {
        Page<ProductEntity> productEntities = jpaProductRepository.getProductBySearchQuery(search, pageable);
        return this.castProductEntity(productEntities, pageable);
    }

    @Override
    public Page<Product> findAll(Pageable pageable, Long categoryId) {
        Page<ProductEntity> productEntities = jpaProductRepository.getProductByCategory(categoryId, pageable);
        return this.castProductEntity(productEntities, pageable);
    }

    private Page<Product> castProductEntity(Page<ProductEntity> productEntities, Pageable pageable){
        List<Product> products = new ArrayList<>();
        for (Object productEntity: productEntities.getContent()){
            Product product = new Product();
            BeanUtils.copyProperties(productEntity, product);
            products.add(product);
        }
        return new PageImpl<>(products, pageable, productEntities.getTotalElements());
    }

    private Product castProductEntity(Optional<ProductEntity> productEntity){
        if (productEntity.isEmpty()){
            throw new NoSuchElementException();
        }
        Product product = new Product();
        BeanUtils.copyProperties(productEntity.get(), product);
        return product;
    }

    private List<Product> castProductEntity(List<ProductEntity> productEntities){
        List<Product> products = new ArrayList<>();
        for (ProductEntity productEntity: productEntities){
            Product product = new Product();
            BeanUtils.copyProperties(productEntity, product);
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> productEntities = jpaProductRepository.findAll();
        List<Product> products = new ArrayList<>();
        for (ProductEntity productEntity: productEntities){
            Product product = new Product();
            BeanUtils.copyProperties(productEntity, product);
            products.add(product);
        }
        return products;
    }


    @Override
    @Cacheable(key = "#id" ,value = "ProductCache")
    public Product findById(Long id) {
        Optional<ProductEntity> productEntity = jpaProductRepository.findById(id);
        if (productEntity.isEmpty()){
            throw new NoSuchElementException();
        }
        return this.castProductEntity(productEntity);
    }

    @Override
    @CachePut(key = "#product.id" ,value = "ProductCache")
    public Product save(Product product) {
        ProductEntity productEntities = new ProductEntity();
        BeanUtils.copyProperties(product, productEntities);
        productEntities = jpaProductRepository.save(productEntities);
        BeanUtils.copyProperties(productEntities, product);
        return product;
    }

    @Override
    @CachePut(key = "#id" ,value = "ProductCache")
    public boolean deleteById(Long id) {
        this.findById(id);
        jpaProductRepository.deleteById(id);
        return true;
    }

    @Override
    public Object existsById(Long expectedId) {
        return null;
    }
    @Override
    public List<Product> findAll(List<Long> ids) {
        List<ProductEntity> productEntities = jpaProductRepository.findAllByIdIn(ids);
        return this.castProductEntity(productEntities);
    }

}
