package com.portal.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.portal.web.security.AppSecurityConfig;

@SpringBootApplication
@ComponentScan(basePackages = { "com.portal.rest.controller", "com.portal.core", "com.portal.web.security",
"com.portal.web.security.handler","com.portal.web.filter", "com.portal.web.mvc.controller"  })
public class SpringBootWebApplication extends SpringBootServletInitializer{
 
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(SpringBootWebApplication.class, AppSecurityConfig.class);
//    }
 
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}