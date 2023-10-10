package com.dio.live.coding.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.coding.springboot.dto.UserModelDTO;
import com.dio.live.coding.springboot.model.UserModel;
import com.dio.live.coding.springboot.repository.UserRespository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    
    @Autowired
    private  UserRespository userRepository;

    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }

    public UserModel getUser(Long id){
    
            return userRepository.findById(id).orElseThrow(() -> {
                log.error("Error on getUsers");
                return new RuntimeException("User not found with id: " + id);

            });
    }

    public UserModel createUser(UserModelDTO userModelDto){
        UserModel userModel = new UserModel(userModelDto.getName(),userModelDto.getEmail());

        return userRepository.save(userModel);
    }

    public UserModel update(Long id, UserModelDTO userModelDTO){
        UserModel userModel = userRepository.findById(id).orElseThrow(() -> {
            log.error("Error on Update, user id not found");
            return new RuntimeException("User not found with id: " + id);
        });

        userModel.setName(userModelDTO.getName());
        userModel.setEmail(userModelDTO.getEmail());

        return userRepository.save(userModel);
    }

    public UserModel delete(Long id){
         UserModel userModel = userRepository.findById(id).orElseThrow(() -> {
            log.error("Error on Delete, user id not found");
            return new RuntimeException("User not found with id: " + id);
        });

        userRepository.delete(userModel);
        return userModel;
    }
}
