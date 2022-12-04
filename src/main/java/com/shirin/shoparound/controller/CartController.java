package com.shirin.shoparound.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shirin.shoparound.entity.Address;
import com.shirin.shoparound.entity.Cart;
import com.shirin.shoparound.entity.CartRequest;
import com.shirin.shoparound.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    CartService service;

    @PostMapping()
    public void addToCart(@RequestBody CartRequest request){
        service.addToCart(request);

    }
    @GetMapping("/{userId}")
    public Optional<Cart> getCart(@PathVariable String userId){
       return service.getCart(userId);
    }
    
    @PatchMapping("/address")
    public void addAddress(@RequestBody Address address){
        service.addAddress(address);
    }
    @PatchMapping("/submit/{userId}")
    public void submit(@PathVariable  String userId){
        service.submit(userId);
    }


    @PatchMapping()
    public void deleteItemFromCart(@RequestBody CartRequest request){
        service.deleteItemFromACart(request);
    }
}
