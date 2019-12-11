package com.example.demo.map;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.bean.Category;


@Mapper
public interface CategoryMapper {

	@Select("select * from Category")
	public List<Category> findAll();

	 @Insert("insert into Category(id, name) values(#{idCategory},#{name})")
	    void insert(Category category);
	 
}
