package com.shirin.shoparound.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shirin.shoparound.entity.Cart;

public interface CartRepository extends MongoRepository <Cart,String>{

    Optional<Cart> findByUserIdAndSubmittedFalse(String userId);
}

    

