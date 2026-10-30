package com.service;


import com.exception.BusinessException;
import com.mapper.ProductMapper;
import com.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public Product findByName(String name){
        if (name == null || name.trim().length() == 0){
            throw new BusinessException("404","商品名字不能为空！");
        }
        return productMapper.findByName(name);
    }
}
