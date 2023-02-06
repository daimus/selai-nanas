package com.example.productservice.infrastructure.presenter.rest.productCategory;

import com.example.productservice.application.products.entity.ProductCategory;
import com.example.productservice.application.products.service.ProductCategoryService;
import com.example.productservice.infrastructure.presenter.rest.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@Slf4j
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;
    @GetMapping
    public ResponseEntity<Object> getProductCategory(){
        log.info("GET /category/{id} called");
        Response response = new Response();
        List<ProductCategory> productCategory = productCategoryService.getProductCategory();
        response.setData(productCategory);
        return response.getResponse();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getProductCategoryById(@PathVariable Long id){
        log.info("GET /category/{id} called");
        Response response = new Response();
        ProductCategory productCategory = productCategoryService.getProductCategoryById(id);
        response.setData(productCategory);
        return response.getResponse();
    }
    @PostMapping
    public ResponseEntity<Object> saveProductCategory(@Valid @RequestBody ProductCategory productCategory){
        log.info("GET /category/{id} called");
        Response response = new Response();
        productCategory = productCategoryService.saveProductCategory(productCategory);
        response.setData(productCategory);
        response.setHttpCode(201);
        return response.getResponse();
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Object> saveProductCategory(@PathVariable Long id, @RequestBody ProductCategory productCategory){
        log.info("GET /category/{id} called");
        Response response = new Response();
        productCategory = productCategoryService.saveProductCategory(id, productCategory);
        response.setData(productCategory);
        return response.getResponse();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteProductCategoryById(@PathVariable Long id){
        log.info("GET /category/{id} called");
        Response response = new Response();
        productCategoryService.deleteProductCategoryById(id);
        response.setHttpCode(204);
        return response.getResponse();
    }
}
