package com.myapp.pengeluaranku.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserReqVO{
    @NotBlank(message = "Name can't be empty")
    private String name;
    private String address;
    @NotBlank(message = "Phone can't be empty")
    private String phone;
    @NotBlank(message = "Email can't be empty")
    private String email;
    public UserReqVO(){};
    public UserReqVO(String name, String email, String address,String phone){
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
}

}