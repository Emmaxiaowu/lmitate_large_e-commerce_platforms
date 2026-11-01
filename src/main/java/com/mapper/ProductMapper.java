package com.mapper;

import com.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    //根据名字查询商品
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
            "select count(*) from product"
    )
    public int count();

    //查询某页的商品
    @Select(
            "select * from product order by productId ASC limit #{pageSize} offset #{skip}"
    )
    public List<Product> findByPage(Integer skip,Integer pageSize);





}
