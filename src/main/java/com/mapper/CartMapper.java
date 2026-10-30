package com.mapper;

import com.entity.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CartMapper {

    @Insert("insert into cart (userId,productId,product_name,quantity,price)" +
            " values (#{userId},#{productId},#{product_name},#{quantity},#{price})"
    )
    int addToCart(Cart cart);
}
