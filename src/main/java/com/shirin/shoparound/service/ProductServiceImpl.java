package com.shirin.shoparound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shirin.shoparound.entity.Product;
import com.shirin.shoparound.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
  
    @Autowired
    private ProductRepository repository;


    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return repository.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
       return repository.save(product);
    }
    
}
