package com.service;

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

    public void register(User user){

        if (user == null || user.getAccount() == null || user.getPassword() == null || user.getUsername() == null){
            throw new BusinessException("201","账号、密码、用户名不能为空！");
        }
        //isBlank判断字符串是否为空，或者只包含空白字符串
        if (user.getAccount().isBlank() || user.getPassword().isBlank() || user.getUsername().isBlank()){
            throw new BusinessException("201","账号、密码、用户名不能为空！");
        }
        User hasExist = userMapper.findByAccount(user.getAccount());
        if (hasExist != null){
            throw new BusinessException("201","账号已存在！");
        }
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        int rows = userMapper.register(user);
        if (rows != 1){
            throw new BusinessException("201","注册失败！");
        }
    }

    public User login(User user){

        if (user == null || user.getAccount() == null || user.getPassword() == null){
            throw new BusinessException("202","账号、密码不能为空！");
        }
        if (user.getAccount().isBlank() || user.getPassword().isBlank()){
            throw new BusinessException("202","账号、密码不能为空！");
        }
        User user2 = userMapper.findByAccount(user.getAccount());
        if (user2 == null){
            throw new BusinessException("202","账号不存在！请先注册！");
        }
        if (user2.getAccount().equals(user.getAccount()) && passwordEncoder.matches(user.getPassword(),user2.getPassword())){
            int userId = user.getUserId();
        }else {
            throw new BusinessException("202","账号或密码错误！");
        }

        return user;
    }
}

