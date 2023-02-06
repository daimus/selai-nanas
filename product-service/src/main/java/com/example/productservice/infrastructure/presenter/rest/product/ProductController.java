package com.example.productservice.infrastructure.presenter.rest.product;

import com.example.productservice.application.products.entity.Product;
import com.example.productservice.application.products.service.ProductService;
import com.example.productservice.infrastructure.presenter.rest.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<Object> getProduct(){
        log.info("GET /product/{id} called");
        Response response = new Response();
        List<Product> product = productService.getProduct();
        response.setData(product);
        return response.getResponse();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id){
        log.info("GET /product/{id} called");
        Response response = new Response();
        Product product = productService.getProductById(id);
        response.setData(product);
        return response.getResponse();
    }
    @PostMapping
    public ResponseEntity<Object> createProduct(@Valid @RequestBody Product product){
        log.info("GET /product/{id} called");
        Response response = new Response();
        product = productService.saveProduct(product);
        response.setData(product);
        response.setHttpCode(201);
        return response.getResponse();
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody Product product){
        log.info("GET /product/{id} called");
        Response response = new Response();
        product = productService.saveProduct(id, product);
        response.setData(product);
        return response.getResponse();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id){
        log.info("GET /product/{id} called");
        Response response = new Response();
        productService.deleteProductById(id);
        response.setHttpCode(204);
        return response.getResponse();
    }
}
