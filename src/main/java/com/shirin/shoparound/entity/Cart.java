package com.shirin.shoparound.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Cart {

    String id;
    String userId;
    List<Product> products = new ArrayList<>();
    double totalPrice;
    Address address;
    boolean submitted;

    public Cart(String userId){
        this.userId=userId;
    }
    
}
