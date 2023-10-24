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
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @GetMapping(path = "/admin/product")
    public String getProductPage(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product";
    }
    @GetMapping(path = "/admin/product/addnew")
    public String addNewProductPage(Model model){
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "add-new-product";
    }

    @PostMapping(path = "/admin/product/save")
    public String saveProduct(Product product){
        productService.save(product);
        return "redirect:/admin/product";
    }

    @GetMapping(path = "/admin/product/update/{id}")
    public String findProductById(@PathVariable Long id, Model model){
        Product product = productService.findById(id).orElse(null);
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("product", product);
        model.addAttribute("categories",categories);
        return "update-product";
    }
    @RequestMapping(path = "/admin/product/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
        return "redirect:/admin/product";
    }
    @GetMapping(path = "/home/{id}")
    public String getProductByCategoryId(@PathVariable Long id, Model model){
        List<Category> categories = categoryService.getAllCategory();
        List<Product> products = productService.findByCategoryId(id);
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "home";
    }
}
