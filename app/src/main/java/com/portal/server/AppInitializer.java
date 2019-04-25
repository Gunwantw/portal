package com.portal.server;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.portal.web.filter.MyFilter;

import com.portal.web.mvc.MvcConfig;
import com.portal.web.security.AppSecurityConfig;

public class AppInitializer  {

}

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = { "com.portal.rest.controller", "com.portal.core", "com.portal.web.security",
//		"com.portal.web.security.handler","com.portal.web.filter", "com.portal.web.mvc.controller"  })
//public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		return new Class[] { AppSecurityConfig.class };
//		//return new Class[] {AppInitializer.class, MvcConfig.class};
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		return new Class[] { MvcConfig.class };
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		return new String[] { "/" };
//	}
//
//
//}
