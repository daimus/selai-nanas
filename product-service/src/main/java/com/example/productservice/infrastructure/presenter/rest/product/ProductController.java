package com.example.productservice.infrastructure.presenter.rest.product;

import com.example.productservice.application.products.entity.Product;
import com.example.productservice.application.products.usecase.ProductUseCase;
import com.example.productservice.infrastructure.presenter.rest.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductUseCase productUseCase;
    @GetMapping
    public ResponseEntity<Object> getProduct(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) Long categoryId
    ){
        log.info("GET /products called");
        Response response = new Response();
        Pageable pageable;
        if (sort == null){
            pageable = PageRequest.of(page, size);
        } else {
            String[] sortCriteria = sort.split(",");
            pageable = PageRequest.of(page, size, Sort.by(sortCriteria[1] == "asc" ? Sort.Direction.ASC : Sort.Direction.DESC, sortCriteria[0]));
        }

        Page<Product> products;
        if (search != null && categoryId != null){
            System.out.println("search & category");
            products = productUseCase.getProduct(pageable, search, categoryId);
        } else if (search != null){
            System.out.println("search");
            products = productUseCase.getProduct(pageable, search);
        } else if (categoryId != null){
            System.out.println("category");
            products = productUseCase.getProduct(pageable, categoryId);
        } else {
            System.out.println("none");
            products = productUseCase.getProduct(pageable);
        }
        response.setPageData(products);
        return response.getResponse();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id){
        log.info("GET /products/{} called", id);
        Response response = new Response();
        Product product = productUseCase.getProductById(id);
        response.setData(product);
        return response.getResponse();
    }
    @PostMapping
    public ResponseEntity<Object> createProduct(@Valid @RequestBody Product product){
        log.info("POST /products called with body: {}", product);
        Response response = new Response();
        product = productUseCase.saveProduct(product);
        response.setData(product);
        response.setHttpCode(201);
        return response.getResponse();
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody Product product){
        log.info("PATCH /product/{} called with body: {}", id, product);
        Response response = new Response();
        product = productUseCase.saveProduct(id, product);
        response.setData(product);
        return response.getResponse();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id){
        log.info("DELETE /product/{} called", id);
        Response response = new Response();
        productUseCase.deleteProductById(id);
        response.setHttpCode(204);
        return response.getResponse();
    }
}
