package com.controller;

import com.service.CartService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

//    @PostMapping("/add/{productId}")
//    public String addToCart(@PathVariable("productId") int productId){
//        cartService.addToCart(productId);
//        return "添加成功！";
//    }
}