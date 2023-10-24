package com.project.Mobile.Shop.Project.controller;

import com.project.Mobile.Shop.Project.model.Category;
import com.project.Mobile.Shop.Project.model.Product;
import com.project.Mobile.Shop.Project.service.CategoryService;
import com.project.Mobile.Shop.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/admin/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping
    public String getCategoryPage(Model model){
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "category";
    }
    @GetMapping(path = "/addnew")
    public String addNewCategoryPage(){
        return "add-new-category";
    }
    @PostMapping(path = "/save")
    public String saveNewCategory(Category category){
        categoryService.save(category);
        return "redirect:/admin/category";
    }
    @GetMapping(path = "/update/{id}")
    public String updateCategoryById(@PathVariable Long id, Model model){
        Category category = categoryService.findById(id).orElse(null);
        model.addAttribute("category", category);
        return "update-category";
    }

    @RequestMapping(path = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
        return "redirect:/admin/category";
    }
}
