package com.controller;


import com.entity.Product;
import com.exception.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/name/{name}")
    public Product findByName(@PathVariable String name){
        return productService.findByName(name);
    }

    @GetMapping("/error/test")
    public String test(){
        throw new RuntimeException("这是一次异常测试！");
    }
}
