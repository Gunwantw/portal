package com.portal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	
	@GetMapping
    public String sayHello() {
<<<<<<< HEAD
		return "Hello from Spring 5 and embedded Tomcat 8!***************************";
=======
		System.out.println("HelloWorldController.sayHello()");
        return "Hello from Spring 5 and embedded Tomcat 8!***************************";
        
>>>>>>> 20d640f06eb36aca9ae47b862acf5cbf7107c075
    }
}

