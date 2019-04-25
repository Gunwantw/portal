package com.portal.server;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

public class SpringAppConfig {
	
}

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = { "com.portal.controller", "com.portal.core", "com.portal.web.security",
//"com.portal.web.security.handler","com.portal.web.filter"  })
//public class SpringAppConfig   implements WebApplicationInitializer{
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		
//		
//		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//		rootContext.register(SpringAppConfig.class);
//		
//		servletContext.addListener(new ContextLoaderListener(rootContext));
//		//ApplicationContext ctx = new Annot
//		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
//		
//		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("apidispatcher", new DispatcherServlet(dispatcherContext));
//		
//		dispatcher.setLoadOnStartup(1);
//		
//		dispatcher.addMapping("/");
//		
//		servletContext.addFilter("myfiletr", new MyFilter());
////		ServletRegistration.Dynamic mvcDispature = servletContext.addServlet("mvcdispatcher", new DispatcherServlet(dispatcherContext));
////		mvcDispature.setLoadOnStartup(2);
////		
//////		mvcDispature.addMapping("/mvc/*");
//		
//		//servletContext.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
//	    //    .addMappingForUrlPatterns(null, false, "/*");
//		
//	}
//
//}
