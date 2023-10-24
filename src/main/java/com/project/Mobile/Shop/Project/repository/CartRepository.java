package com.project.Mobile.Shop.Project.repository;

import com.project.Mobile.Shop.Project.model.Cart;
import com.project.Mobile.Shop.Project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByProduct(Product product);
}
