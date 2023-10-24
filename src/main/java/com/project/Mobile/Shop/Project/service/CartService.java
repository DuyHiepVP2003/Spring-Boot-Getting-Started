package com.project.Mobile.Shop.Project.service;

import com.project.Mobile.Shop.Project.model.Cart;
import com.project.Mobile.Shop.Project.model.Product;
import com.project.Mobile.Shop.Project.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionScope
@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    public List<Cart> findAll(){
        return cartRepository.findAll();
    }
    public void save(Cart cart){
        cartRepository.save(cart);
    }
    public Cart findByProduct(Product product){
        return cartRepository.findByProduct(product);
    }
}
