package com.example.demo.map;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.bean.Client;
import com.example.demo.bean.Product;

@Mapper
public interface ProductMapper {

	@Insert("insert into Product(name, description, lastUpdate, price, category) values(#{name},#{description},#{lastUpdate},#{price},#{category.id})")
    void insert(Product product);
	
	@Select("select * from Product")
    public List<Product> findAll();


	@Select("select * from Product where name = #{name}")
	public Product findByName(String name);
}
