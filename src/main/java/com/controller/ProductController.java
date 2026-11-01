package com.controller;


import com.dto.request.PageResult;
import com.dto.request.UserLoginRequest;
import com.entity.Product;
import org.springframework.web.bind.annotation.*;
import com.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/name/{name}")
    public List<Product> findByName(@RequestBody UserLoginRequest request, @PathVariable String name){
        return productService.findByName(request,name);
    }

   @GetMapping("/id/{id}")
    public Product findById(@PathVariable Integer id){
        return productService.findById(id);
    }

    //需要获取第几页和页数
    @GetMapping("/page")
    public PageResult<Product> findByPage(@RequestParam Integer page, @RequestParam Integer pageSize){
        return productService.findByPage(page,pageSize);
    }
}
