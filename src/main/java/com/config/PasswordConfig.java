package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration//告诉Spring这是一个配置类
public class PasswordConfig {

    @Bean//将方法返回的对象注册到Spring容器中
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();//创建一个能够执行BCrypt哈希的对象
    }
}
