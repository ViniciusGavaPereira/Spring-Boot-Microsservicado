package com.dio.live.coding.springboot.dto;

import javax.validation.constraints.NotEmpty;

public class UserModelDTO {
    

    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "E-mail is required")
    private String email;


    public UserModelDTO() {
    }

    public UserModelDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
