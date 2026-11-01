package com.service;


import com.dto.request.PageResult;
import com.dto.request.UserLoginRequest;
import com.entity.User;
import com.exception.BusinessException;
import com.mapper.ProductMapper;
import com.entity.Product;
import com.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final UserMapper userMapper;

    private final ProductMapper productMapper;

    public ProductService(UserMapper userMapper, ProductMapper productMapper) {
        this.userMapper = userMapper;
        this.productMapper = productMapper;
    }

    //根据商品名查询商品
    public List<Product> findByName(UserLoginRequest request,String name){

        User user = userMapper.findByAccount(request.getAccount());
        if (user == null){
            throw new BusinessException("404","请先登录！");
        }
        if (name == null || name.trim().length() == 0){
            throw new BusinessException("404","商品名字不能为空！");
        }
        return productMapper.findByName(name);
    }

    //根据ID查询商品
    public Product findById(Integer id){

        if (id == null){
            throw new BusinessException("404","商品ID不能为空！");
        }
        Product product = productMapper.findById(id);
        if (product == null){
            throw new BusinessException("404","商品不存在！");
        }
        return productMapper.findById(id);
    }

    //分页查询商品
    public PageResult<Product> findByPage(Integer page, Integer pageSize){
        //对传过来的页码进行判断和计算
        if(page == null || page < 1){
            throw new BusinessException("404","页码不能为空！");
        }
        if (pageSize == null || pageSize < 1){
            throw new BusinessException("404","页码大小不能为空！");
        }else if (pageSize > 100){
            throw new BusinessException("404","页码大小不能超过100！");
        }
        PageResult<Product> pageResult = new PageResult<>();
        int skip = (page - 1) * pageSize;
        pageResult.setRecords(productMapper.findByPage(skip,pageSize));
        pageResult.setCount(productMapper.count());
        pageResult.setPage(page);
        pageResult.setPageSize(pageSize);
        return pageResult;
    }
}
