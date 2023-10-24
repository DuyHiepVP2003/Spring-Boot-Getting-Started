package com.project.Mobile.Shop.Project.service;

import com.project.Mobile.Shop.Project.model.User;
import com.project.Mobile.Shop.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public void addNewUser(User user){
        userRepository.save(user);
    }
    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
    public boolean doesUserExist(String username){
        return userRepository.existsByUsername(username);
    }
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public boolean doesEmailExist(String email){
        return userRepository.existsByEmail(email);
    }

}
