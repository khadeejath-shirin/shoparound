package com.shirin.shoparound.service;

import java.util.Optional;

import com.shirin.shoparound.entity.Address;
import com.shirin.shoparound.entity.Cart;
import com.shirin.shoparound.entity.CartRequest;

public interface CartService {
    void addToCart(CartRequest cartRequest);
    Optional<Cart> getCart(String userId);
    void addAddress(Address address) ;
    void submit(String userId) ;
    void deleteItemFromACart(CartRequest request);
}
