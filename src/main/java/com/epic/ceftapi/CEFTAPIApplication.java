package com.epic.ceftapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext; 
 

@SpringBootApplication
public class CEFTAPIApplication {
	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(CEFTAPIApplication.class, args);
	}

}