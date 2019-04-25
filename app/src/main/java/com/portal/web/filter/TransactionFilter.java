package com.portal.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


public class TransactionFilter
{
	
}
//@Component
//@Order(1)
//public class TransactionFilter implements Filter {
// 
//    
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		System.out.println("Filter Init############################");
//		
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, javax.servlet.ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		System.out.println("Filter############################");
//		
//	}
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		
//	}
// 
//    // other methods 
//}