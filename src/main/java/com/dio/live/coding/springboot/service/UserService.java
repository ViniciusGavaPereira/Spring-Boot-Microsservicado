package com.dio.live.coding.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.coding.springboot.repository.UserRespository;

@Service
public class UserService {
    
    @Autowired
    private  UserRespository userRespository;
}
