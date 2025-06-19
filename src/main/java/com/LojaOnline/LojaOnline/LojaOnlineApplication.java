package com.LojaOnline.LojaOnline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LojaOnlineApplication {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver PostgreSQL carregado");
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		SpringApplication.run(LojaOnlineApplication.class, args);
	}

}
