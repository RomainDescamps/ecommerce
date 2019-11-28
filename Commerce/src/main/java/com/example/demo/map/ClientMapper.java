package com.example.demo.map;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.bean.Client;

@Mapper
public interface ClientMapper {
	
	@Select("select * from Client")
    public List<Client> findAll();

	
	 
    @Insert("insert into Client(nom, prenom, adresse, telephone, email) values(#{nom},#{prenom},#{adresse},#{telephone},#{email})")
    void insert(Client client);



	

}
