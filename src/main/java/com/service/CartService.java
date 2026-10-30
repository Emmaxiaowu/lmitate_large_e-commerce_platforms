package com.service;

import com.entity.Cart;
import com.exception.BusinessException;
import com.mapper.CartMapper;
import org.springframework.stereotype.Service;

@Service
public class CartService {


    private final CartMapper cartMapper;

    public CartService(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }


    public int addToCart(int userId,int productId){
        if (productId < 0){
            throw new BusinessException("101","商品ID不合法！");
        }
        return cartMapper.addToCart(new Cart());

    }
}
