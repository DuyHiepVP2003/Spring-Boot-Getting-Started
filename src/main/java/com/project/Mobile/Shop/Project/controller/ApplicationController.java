package com.project.Mobile.Shop.Project.controller;

import com.project.Mobile.Shop.Project.model.Category;
import com.project.Mobile.Shop.Project.model.Product;
import com.project.Mobile.Shop.Project.service.CategoryService;
import com.project.Mobile.Shop.Project.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ApplicationController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @GetMapping(path = "")
    public String goHome(){
        return "redirect:/home";
    }
    @GetMapping(path = "/home")
    public String getHomePage(Model model){
        List<Category> categories = categoryService.getAllCategory();
        List<Product> products = productService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "home";
    }
    @GetMapping(path = "/admin")
    public String getAdminPage(HttpSession session){
        if(session.getAttribute("username")!=null){
            return "admin";
        }
        return "login";
    }

    @GetMapping(path = "/layout")
    public String getLayout(){
        return "header";
    }
}
