package com.shirin.shoparound.service;

import java.util.List;
import java.util.Optional;

import com.shirin.shoparound.entity.Product;

public interface ProductService {
   public List<Product> getAllProducts();
   public Optional<Product> getProductById(String id);
   public Product createProduct(Product product);
    
}
