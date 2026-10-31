package com.dto.request;

import com.entity.User;

public class UserRegisterRequest {

    private User user;

    private String username;
    private String password;
    private String email;
    private String account;

    public UserRegisterRequest(){}

    public UserRegisterRequest(String username, String password, String email, String account) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public User getUser() {
        return user;
    }
}
