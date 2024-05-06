package com.pejo.anna.gestorCursosApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class GestorCursosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorCursosApiApplication.class, args);
	}

}
