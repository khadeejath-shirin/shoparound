package com.shirin.shoparound.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shirin.shoparound.entity.Product;
import com.shirin.shoparound.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping()
    public List<Product> getProduct(){
        return service.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable String id){
        return service.getProductById(id);
    }
    @PostMapping()
    public Product createProduct(@RequestBody Product product){
     return   service.createProduct(product);
    
    }
}
