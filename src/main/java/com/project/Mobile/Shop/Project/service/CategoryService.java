package com.project.Mobile.Shop.Project.service;

import com.project.Mobile.Shop.Project.model.Category;
import com.project.Mobile.Shop.Project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    public void save(Category category){
        categoryRepository.save(category);
    }
    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }
    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }
}
