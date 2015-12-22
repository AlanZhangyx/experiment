package com.ddup.spring.mvc.dto;

import org.hibernate.validator.constraints.NotBlank;

public class TestReq {
	@NotBlank(message = "{error.user.userName.NotBlank}")
    private String userName;
    private String password;
    
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
