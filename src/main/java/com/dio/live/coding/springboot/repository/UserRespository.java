package com.dio.live.coding.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.live.coding.springboot.model.UserModel;

@Repository
public interface UserRespository extends JpaRepository<UserModel,Long>{
    
}
