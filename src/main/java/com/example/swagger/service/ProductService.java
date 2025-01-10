package com.example.swagger.service;

import com.example.swagger.model.Product;
import com.example.swagger.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Cacheable(value ="products" )
    public List <Product> findAll() {

        try {
            Thread.sleep ( 10000 );

        }catch (InterruptedException e) {

        }


        return productRepository.findAll ( );
    }
    @CacheEvict(cacheNames = "products", allEntries = true)
    public Product saveProduct( ) {
        Product product = new Product();
        product.setName ("proB" );
        product.setCode ( "PRO_B" );
       return  productRepository.save ( product );
    }
    @CachePut(cacheNames = "products", key="#name")
    public void updateProduct( String name ) {
        Product product = productRepository.findByName ( name )
                .orElseThrow ( NoSuchElementException::new );
        product.setName ( "proUpdate" );
        productRepository.save(product);

    }



}
