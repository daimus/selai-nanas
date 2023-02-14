package com.example.productservice;

import com.example.productservice.application.categories.entity.ProductCategory;
import com.example.productservice.application.categories.repository.ProductCategoryRepository;
import com.example.productservice.application.categories.service.ProductCategoryService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class CategoryServiceApplicationTests {
    @Mock
    ProductCategoryRepository categoryRepository;
    @InjectMocks
    ProductCategoryService categoryService;

    @Test
    public void getProduct_WhenProductExist_ShouldReturnListOfProduct() {
        EasyRandom easyRandom = new EasyRandom();
        // Given
        List<ProductCategory> expectedProduct = new ArrayList<>();
        expectedProduct.add(easyRandom.nextObject(ProductCategory.class));
        expectedProduct.add(easyRandom.nextObject(ProductCategory.class));
        expectedProduct.add(easyRandom.nextObject(ProductCategory.class));
        given(categoryRepository.findAll()).willReturn(expectedProduct);
        // When
        List<ProductCategory> actualProduct = categoryService.getProductCategory();
        // Then
        assertEquals(expectedProduct, actualProduct);
    }
    @Test
    public void saveProduct_WhenProductValid_ShouldReturnProduct(){
        EasyRandom easyRandom = new EasyRandom();
        // Given
        ProductCategory expectedProduct = easyRandom.nextObject(ProductCategory.class);
        given(categoryRepository.save(expectedProduct)).willReturn(expectedProduct);
        // When
        ProductCategory actualProduct = categoryService.saveProductCategory(expectedProduct);
        // Then
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void getProductCategory_WhenCategoriesExist_ShouldReturnListOfCategories() {
        EasyRandom easyRandom = new EasyRandom();
        // Given
        List<ProductCategory> expectedCategories = new ArrayList<>();
        expectedCategories.add(easyRandom.nextObject(ProductCategory.class));
        expectedCategories.add(easyRandom.nextObject(ProductCategory.class));
        expectedCategories.add(easyRandom.nextObject(ProductCategory.class));
        given(categoryRepository.findAll()).willReturn(expectedCategories);

        // When
        List<ProductCategory> actualCategories = categoryService.getProductCategory();

        // Then
        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    public void getProductCategoryById_WhenCategoryExist_ShouldReturnCategory() {
        // Given
        Long categoryId = 1L;
        ProductCategory expectedCategory = new ProductCategory(categoryId, "Kategory");
        given(categoryRepository.findById(anyLong())).willReturn(expectedCategory);
        // When
        ProductCategory actualCategory = categoryService.getProductCategoryById(categoryId);

        // Then
        assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void saveProductCategory_WhenCategoryValid_ShouldReturnCategory() {
        EasyRandom easyRandom = new EasyRandom();
        // Given
        ProductCategory expectedCategory = easyRandom.nextObject(ProductCategory.class);
        given(categoryRepository.save(expectedCategory)).willReturn(expectedCategory);

        // When
        ProductCategory actualCategory = categoryService.saveProductCategory(expectedCategory);

        // Then
        assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void saveProductCategory_WhenCategoryWithIdValid_ShouldReturnCategory() {
        EasyRandom easyRandom = new EasyRandom();
        // Given
        Long categoryId = 1L;
        ProductCategory existingCategory = easyRandom.nextObject(ProductCategory.class);
        existingCategory.setId(categoryId);
        ProductCategory expectedCategory = easyRandom.nextObject(ProductCategory.class);
        given(categoryRepository.findById(categoryId)).willReturn(existingCategory);
        given(categoryRepository.save(expectedCategory)).willReturn(expectedCategory);

        // When
        ProductCategory actualCategory = categoryService.saveProductCategory(categoryId, expectedCategory);

        // Then
        assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void deleteProductCategoryById_WhenCategoryExist_ShouldReturnTrue() {
        // Given
        Long categoryId = 1L;

        // When
        boolean result = categoryService.deleteProductCategoryById(categoryId);

        // Then
        assertTrue(result);
    }
}
