package com.example.demo;

import java.util.List;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.bean.Client;
import com.example.demo.map.ClientMapper;


@MappedTypes(Client.class)
@MapperScan("com.example.demo.map")
@SpringBootApplication
public class CommerceApplication implements CommandLineRunner {

	private final ClientMapper clientMapper;

	public CommerceApplication(ClientMapper clientMapper) {
		this.clientMapper = clientMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(CommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		
		
		List<Client> clients = this.clientMapper.findAll();

		for (int i = 0; i < clients.size(); i++) {
			System.out.println(clients.get(i).toString());


		}
		
		
		
	}

}
