package com.shirin.shoparound.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shirin.shoparound.entity.Address;
import com.shirin.shoparound.entity.Cart;
import com.shirin.shoparound.entity.CartRequest;
import com.shirin.shoparound.entity.Product;
import com.shirin.shoparound.repository.CartRepository;
import com.shirin.shoparound.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository repository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void addToCart(CartRequest cartRequest) throws RuntimeException {
       Cart cart=repository.findByUserIdAndSubmittedFalse(cartRequest.getUserId())
       .orElse(new Cart(cartRequest.getUserId()));
       Optional<Product> product=productRepository.findById(cartRequest.getProductId());
       if(product.isPresent()){
         List<Product> products=cart.getProducts();
         products.add(product.get());
         double totalPrice=cart.getTotalPrice()+product.get().getPrice();
         cart.setTotalPrice(totalPrice);
         repository.save(cart);
       }else{
        throw new RuntimeException("Product Not Found");
       }
        
    }

    @Override
    public Optional<Cart> getCart(String userId) {
      return repository.findByUserIdAndSubmittedFalse(userId);
    }

    @Override
    public void addAddress(Address address) throws RuntimeException {
        Optional<Cart> cart=repository.findByUserIdAndSubmittedFalse(address.getUserId());
        if(cart.isPresent()){
            cart.get().setAddress(address);
            repository.save(cart.get());
        }else{
            throw new RuntimeException("Cart Doesn't Exist");
        }
       
    }

    @Override
    public void submit(String userId) throws RuntimeException {
        Optional<Cart> cart=repository.findByUserIdAndSubmittedFalse(userId);
        if(cart.isPresent()){
            cart.get().setSubmitted(true);
            repository.save(cart.get());
        }else{
            throw new RuntimeException("Cart Doesn't Exist");
        }
       
        
        
    }

    @Override
    public void deleteItemFromACart(CartRequest request) {
      Optional<Cart> cart= repository.findByUserIdAndSubmittedFalse( request.getUserId());
      if(cart.isPresent()){
       List<Product>products= cart.get().getProducts();
       Predicate<? super Product> predicate=product->product.getId().equals(request.getProductId());
		products.removeIf(predicate);
        repository.save(cart.get());
    }else{
        throw new RuntimeException("Cart Doesn't Exist");
    }
   

        
    }

    
}
