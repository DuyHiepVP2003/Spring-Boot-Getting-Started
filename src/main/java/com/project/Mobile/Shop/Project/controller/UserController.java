package com.project.Mobile.Shop.Project.controller;

import com.project.Mobile.Shop.Project.model.User;
import com.project.Mobile.Shop.Project.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(path = "/admin/user")
    public String userManagePage(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping(path = "/admin/user/addnew")
    public String getNewUser(){
        return "add-new-user";
    }

    @PostMapping(path = "/save")
    public String addNewUser(User user, Model model){
        if(userService.doesUserExist(user.getUsername())){
            model.addAttribute("message", "Username exist");
            return "add-new-user";
        }
        if(userService.doesEmailExist(user.getEmail())){
            model.addAttribute("message2","Email exist");
            return "add-new-user";
        }
        userService.addNewUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping(path = "/admin/user/update/{id}")
    public String findById(@PathVariable Long id, Model model){
        User user = userService.findUserById(id).orElse(null);
        model.addAttribute("user",user);
        return "update-user";
    }

    @PostMapping(path = "/admin/user/update/save")
    public String updateUser(User user){
        userService.addNewUser(user);
        return "redirect:/admin/user";
    }
    @RequestMapping(path = "/admin/user/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteUser(@PathVariable Long id, Model model){
        userService.deleteById(id);
        return "redirect:/admin/user";
    }

    @GetMapping(path = "/checklogin")
    public String checkLogin(@RequestParam("username")String username
            , @RequestParam("password")String password
            , Model model
            , HttpSession session){
        if(userService.doesUserExist(username)){
            if (userService.findByUsername(username).getPassword().equals(password)){
                session.setAttribute("username",username);
                return "redirect:/admin";
            }
            else{
                model.addAttribute("message","Password is wrong");
                return "login";
            }
        }else{
            model.addAttribute("message","Username does not exist");
            return "login";
        }
    }

    @GetMapping(path = "/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpSession session){
        session.removeAttribute("username");
        return "redirect:/login";
    }
}
