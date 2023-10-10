package com.dio.live.coding.springboot.controller;

import java.util.List;

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

import com.dio.live.coding.springboot.dto.UserModelDTO;
import com.dio.live.coding.springboot.model.UserModel;
import com.dio.live.coding.springboot.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserModel>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> geUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }
    
    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody UserModelDTO userModelDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userModelDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> update(@PathVariable Long id, @RequestBody UserModelDTO userDTO){
        return ResponseEntity.ok(userService.update(id, userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserModel> delete(@PathVariable Long id){
        return ResponseEntity.ok(userService.delete(id));
    }

}
