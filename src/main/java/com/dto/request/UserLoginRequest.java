package com.dto.request;

public class UserLoginRequest {
    private String account;
    private String password;

    public UserLoginRequest(){}

    public UserLoginRequest(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

}
