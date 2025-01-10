package com.example.swagger.controller;

import com.example.swagger.model.Product;
import com.example.swagger.service.ProductService;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;


    public ProductController ( ProductService productService ) {
        this.productService=productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct() {
        productService.saveProduct();
    }
    @GetMapping
    public List < Product > getProducts() {
        return productService.findAll ();
    }
    @PutMapping("{name}")
    public void updateProduct( @PathVariable String name ) {
        productService.updateProduct(name);
    }

}
