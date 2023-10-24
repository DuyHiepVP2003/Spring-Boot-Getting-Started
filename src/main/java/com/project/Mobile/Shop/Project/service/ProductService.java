package com.project.Mobile.Shop.Project.service;

import com.project.Mobile.Shop.Project.model.Product;
import com.project.Mobile.Shop.Project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public void save(Product product){
        productRepository.save(product);
    }
    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
    public List<Product> findByCategoryId(Long id){
        return productRepository.findByCategoryId(id);
    }
}
