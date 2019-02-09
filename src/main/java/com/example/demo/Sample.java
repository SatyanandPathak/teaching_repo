package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Sample implements HelloInterface{

	@Override
	public String sayHello(String language) {
		if (language.equals("English")){
			return "Hello";
		}
		else {
			return "I dont know your langiage";
		}
		
	}

	

}
