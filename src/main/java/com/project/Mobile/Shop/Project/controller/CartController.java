package com.project.Mobile.Shop.Project.controller;

import com.project.Mobile.Shop.Project.model.Cart;
import com.project.Mobile.Shop.Project.model.Product;
import com.project.Mobile.Shop.Project.service.CartService;
import com.project.Mobile.Shop.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    ProductService productService;
    @Autowired
    private CartService cartService;
    @GetMapping(path = "/cart")
    public String getCartPage(Model model){
        List<Cart> carts = cartService.findAll();
        model.addAttribute("carts",carts);
        return "cart";
    }

    @PostMapping(path = "/home/add-to-cart/{id}")
    public String addToCart(@PathVariable("id") Long id){
        Product product = productService.findById(id).orElse(null);
        if(product!=null){
            Cart cart = cartService.findByProduct(product);
            if(cart!=null){
                cart.setQuantity(cart.getQuantity()+1);
            }
            else {
                Cart newCart = new Cart();
                newCart.setProduct(product);
                newCart.setQuantity(1);
                cartService.save(cart);
            }
        }
        return "redirect:/cart";
    }
}
