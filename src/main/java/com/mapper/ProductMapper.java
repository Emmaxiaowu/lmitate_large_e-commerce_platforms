package com.mapper;

import com.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {

    //根据名字查询商品
    @Select(
            "select * from product where productName = #{name}"
    )
    public Product findByName(String name);
}
