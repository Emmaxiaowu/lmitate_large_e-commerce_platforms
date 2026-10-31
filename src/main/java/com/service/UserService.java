package com.service;

import com.dto.request.UserLoginRequest;
import com.dto.request.UserRegisterRequest;
import com.entity.User;
import com.exception.BusinessException;
import com.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegisterRequest request){

        User user = new User();

        if (request == null || request.getAccount() == null || request.getPassword() == null || request.getUsername() == null){
            throw new BusinessException("201","账号、密码、用户名不能为空！");
        }
        //isBlank判断字符串是否为空，或者只包含空白字符串
        if (request.getAccount().isBlank() || request.getPassword().isBlank() || request.getUsername().isBlank()){
            throw new BusinessException("201","账号、密码、用户名不能为空！");
        }
        User hasExist = userMapper.findByAccount(request.getAccount());
        if (hasExist != null){
            throw new BusinessException("201","账号已存在！");
        }
        user.setAccount(request.getAccount());
        String encode = passwordEncoder.encode(request.getPassword());
        user.setPassword(encode);
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        int rows = userMapper.register(user);
        if (rows != 1){
            throw new BusinessException("201","注册失败！");
        }
    }

    public User login(UserLoginRequest request){

        User user = new User();

        if (request == null || request.getAccount() == null || request.getPassword() == null){
            throw new BusinessException("202","账号、密码不能为空！");
        }
        if (request.getAccount().isBlank() || request.getPassword().isBlank()){
            throw new BusinessException("202","账号、密码不能为空！");
        }
        User request2 = userMapper.findByAccount(request.getAccount());
        if (request2 == null){
            throw new BusinessException("202","账号不存在！请先注册！");
        }
        if (request2.getAccount().equals(request.getAccount()) && passwordEncoder.matches(request.getPassword(),request2.getPassword())){
            user.setAccount(request2.getAccount());
            user.setPassword(request2.getPassword());
            System.out.println("登录成功！");
        }else {
            throw new BusinessException("202","账号或密码错误！");
        }

        return user;
    }
}

