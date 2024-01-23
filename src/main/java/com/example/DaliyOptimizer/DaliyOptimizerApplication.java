package com.example.DaliyOptimizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class DaliyOptimizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaliyOptimizerApplication.class, args);
	}


}
