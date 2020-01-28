package com.myapp.pengeluaranku.vo;

import lombok.Data;

@Data
public class UserResVO{
    private String name;
    private String uuid;
    private String email;
    private String address;
    private String phone;
    public UserResVO(){};
    public UserResVO(String name, String email, String address,String phone){
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
}
}