package com.example.productservice.infrastructure.data.jpa.productCategory;

import com.example.productservice.application.products.entity.ProductCategory;
import com.example.productservice.application.products.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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
        List<ProductCategoryEntity> productCategoryEntitiesEntities = (List<ProductCategoryEntity>) jpaProductCategoryRepository.findAll();
        List<ProductCategory> ProductCategory = new ArrayList<>();
        for (ProductCategoryEntity productCategoryEntity : productCategoryEntitiesEntities){
            ProductCategory productCategory = new ProductCategory();
            BeanUtils.copyProperties(productCategoryEntity, productCategory);
            ProductCategory.add(productCategory);
        }
        return ProductCategory;
    }

    @Override
    public ProductCategory findById(Long id) {
        Optional<ProductCategoryEntity> productCategoryEntityEntities = jpaProductCategoryRepository.findById(id);
        if (productCategoryEntityEntities.isEmpty()){
            throw new NoSuchElementException();
        }
        ProductCategory productCategory = new ProductCategory();
        BeanUtils.copyProperties(productCategoryEntityEntities.get(), productCategory);
        return productCategory;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        ProductCategoryEntity productCategoryEntityEntities = new ProductCategoryEntity();
        BeanUtils.copyProperties(productCategory, productCategoryEntityEntities);
        productCategoryEntityEntities = jpaProductCategoryRepository.save(productCategoryEntityEntities);
        BeanUtils.copyProperties(productCategoryEntityEntities, productCategory);
        return productCategory;
    }

    @Override
    public boolean deleteById(Long id) {
        jpaProductCategoryRepository.deleteById(id);
        return true;
    }

}
