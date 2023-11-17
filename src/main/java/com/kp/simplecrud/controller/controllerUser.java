/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kp.simplecrud.controller;

import com.kp.simplecrud.model.User;
import com.kp.simplecrud.repository.repositoryUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mkindo_Intan
 */
@RestController
@RequestMapping("/users")
public class controllerUser {
    
    @Autowired
    private repositoryUser repositoryuser;
    
    @GetMapping("")
    public List<User> getAllUsers() {
        return repositoryuser.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = repositoryuser.findById(id).orElse(null);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @PostMapping("")    
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = repositoryuser.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User currentUser = repositoryuser.findById(id).orElse(null);
        if (currentUser == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
        currentUser.setAddress(user.getAddress());
        User updatedUser = repositoryuser.save(currentUser);
        
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        User user = repositoryuser.findById(id).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repositoryuser.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
