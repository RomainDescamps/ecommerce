package com.example.demo.map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.Product;

@Mapper
public interface ProductMapper {

	@Insert("insert into Product(name, description, lastUpdate, price, category) values(#{name},#{description},#{lastUpdate},#{price},#{category})")
    void insert(Product product);

}
