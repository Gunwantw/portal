package com.portal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	
	@GetMapping
    public String sayHello() {
		System.out.println("HelloWorldController.sayHello()");
        return "Hello from Spring 5 and embedded Tomcat 8!***************************";
        
    }
}

