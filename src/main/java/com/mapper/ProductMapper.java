package com.mapper;

import com.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    //根据名字查询商品，模糊搜索
    @Select(
            "select * from product where productName like concat('%',#{name},'%')"
    )
    public List<Product> findByName(@Param("name") String name);

    //根据ID查询商品
    @Select(
            "select * from product where productId = #{id}"
    )
    public Product findById(Integer id);

    //查询所有商品的数量
    @Select(
            "select count(*) from product where productName like concat('%',#{Name},'%')"
    )
    public int count(String name);

    //查询某页的商品，并且进行模糊匹配
    @Select(
            "select * from product where productName like concat('%',#{name},'%') order by productId ASC limit #{pageSize} offset #{skip}"
    )
    public List<Product> findByPageAndName(String name,Integer skip,Integer pageSize);





}
