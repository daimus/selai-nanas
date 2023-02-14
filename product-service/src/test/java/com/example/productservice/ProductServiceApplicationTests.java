package com.example.productservice;

import com.example.productservice.application.products.entity.Product;
import com.example.productservice.application.products.repository.ProductRepository;
import com.example.productservice.application.products.service.ProductService;
import jakarta.validation.ConstraintViolationException;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductServiceApplicationTests {
    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductService productService;

    private EasyRandom easyRandom;

    @BeforeEach
    void setUp() {
        easyRandom = new EasyRandom();
    }
    @Test
    void getProduct_WhenProductExist_ShouldReturnListOfProduct() {
        // Given
        List<Product> expectedProduct = new ArrayList<>();
        expectedProduct.add(easyRandom.nextObject(Product.class));
        expectedProduct.add(easyRandom.nextObject(Product.class));
        expectedProduct.add(easyRandom.nextObject(Product.class));
        given(productRepository.findAll()).willReturn(expectedProduct);

        // When
        List<Product> actualProduct = productService.getProduct();

        // Then
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void getProductById_WhenProductExists_ShouldReturnProduct() {
        // Given
        Long productId = 1L;
        Product expectedProduct = easyRandom.nextObject(Product.class);
        expectedProduct.setId(productId);
        given(productRepository.findById(productId)).willReturn(expectedProduct);

        // When
        Product actualProduct = productService.getProductById(productId);

        // Then
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void getProductById_WhenProductDoesNotExist_ShouldReturnNull() {
        // Given
        Long productId = 1L;
        given(productRepository.findById(productId)).willReturn(null);

        // When
        Product actualProduct = productService.getProductById(productId);

        // Then
        assertNull(actualProduct);
    }

    @Test
    void saveProduct_WhenProductIsValid_ShouldReturnProduct() {
        // Given
        Product expectedProduct = easyRandom.nextObject(Product.class);
        given(productRepository.save(expectedProduct)).willReturn(expectedProduct);

        // When
        Product actualProduct = productService.saveProduct(expectedProduct);

        // Then
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void deleteProductById_WhenProductExists_ShouldReturnTrue() {
        EasyRandom easyRandom = new EasyRandom();
        // Given
        Long expectedId = easyRandom.nextLong();
        given(productRepository.existsById(expectedId)).willReturn(true);
        // When
        boolean result = productService.deleteProductById(expectedId);
        // Then
        assertTrue(result);
    }
}