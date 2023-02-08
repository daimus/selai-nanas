package com.example.productservice.infrastructure.data.jpa.productCategory;

import com.example.productservice.application.products.entity.Product;
import com.example.productservice.application.products.entity.ProductCategory;
import com.example.productservice.application.products.repository.ProductCategoryRepository;
import com.example.productservice.infrastructure.data.jpa.product.ProductEntity;
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
public class ProductCategoryRepositoryImpl implements ProductCategoryRepository {
    private final JpaProductCategoryRepository jpaProductCategoryRepository;

    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategoryEntity> productCategoryEntities = (List<ProductCategoryEntity>) jpaProductCategoryRepository.findAll();
        List<ProductCategory> ProductCategory = new ArrayList<>();
        for (ProductCategoryEntity productCategoryEntity : productCategoryEntities){
            ProductCategory productCategory = new ProductCategory();
            BeanUtils.copyProperties(productCategoryEntity, productCategory);
            ProductCategory.add(productCategory);
        }
        return ProductCategory;
    }

    @Override
    public Page<ProductCategory> findAll(Pageable pageable) {
        Page<ProductCategoryEntity> productCategoryEntities = jpaProductCategoryRepository.findAll(pageable);
        List<ProductCategory> ProductCategory = new ArrayList<>();
        for (ProductCategoryEntity productEntity: productCategoryEntities.getContent()){
            ProductCategory product = new ProductCategory();
            BeanUtils.copyProperties(productEntity, product);
            ProductCategory.add(product);
        }
        return new PageImpl<>(ProductCategory, pageable, productCategoryEntities.getTotalElements());
    }

    @Override
    public ProductCategory findById(Long id) {
        Optional<ProductCategoryEntity> productCategoryEntity = jpaProductCategoryRepository.findById(id);
        if (productCategoryEntity.isEmpty()){
            throw new NoSuchElementException();
        }
        ProductCategory productCategory = new ProductCategory();
        BeanUtils.copyProperties(productCategoryEntity.get(), productCategory);
        return productCategory;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        ProductCategoryEntity productCategoryEntities = new ProductCategoryEntity();
        BeanUtils.copyProperties(productCategory, productCategoryEntities);
        productCategoryEntities = jpaProductCategoryRepository.save(productCategoryEntities);
        BeanUtils.copyProperties(productCategoryEntities, productCategory);
        return productCategory;
    }

    @Override
    public boolean deleteById(Long id) {
        jpaProductCategoryRepository.deleteById(id);
        return true;
    }

}
