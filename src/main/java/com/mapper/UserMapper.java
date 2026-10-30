package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    //注册
    @Insert(
            "insert into user(account,username,password,email)values(#{account},#{username},#{password},#{email})"
    )
    public int register(User user);

    //根据唯一信息查询用户是否存在
    @Select(
            "select * from user where account = #{account}"
    )
    public User findByAccount(String account);




}
