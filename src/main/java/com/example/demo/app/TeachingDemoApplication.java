package com.example.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Eligibility criteria # 1
// @ComponentScan(basePackages = {"com.example.demo.app"}) 
// Spring will scan those packages for bean/object creation
@SpringBootApplication
public class TeachingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeachingDemoApplication.class, args);
	}

}

