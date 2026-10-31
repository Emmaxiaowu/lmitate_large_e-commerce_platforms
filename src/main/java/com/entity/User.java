package com.entity;

public class User {
    private String account;//登录/注册的账号
    private String username;//名字
    private String password;//登录/注册的密码
    private int userId;//用户id
    private String email;

    public User(){}


    public User(int userId,String username,String account,String password,String email){
        this.userId = userId;
        this.username = username;
        this.account = account;
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
