package com.portal.web.security;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.portal.web.security.handler.CustomAccessDeniedHandler;
import com.portal.web.security.handler.CustomAuthenticationFailureHandler;
import com.portal.web.security.handler.CustomLogoutSuccessHandler;

//public class AppSecurityConfig{
//	
//}

@Configuration
@EnableWebSecurity
// @Profile("!https")
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	public AppSecurityConfig() {
		super();
	}

	/**
	 * This method will configure in memory authentication manager with users and
	 * roles.
	 */
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("password")).roles("USER")
				.and().withUser("user2").password(passwordEncoder().encode("password")).roles("USER").and()
				.withUser("admin").password(passwordEncoder().encode("password")).roles("ADMIN");

	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("*************************************************************Configure");
		http.authorizeRequests().antMatchers("/login*").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/login.html")
				.loginProcessingUrl("/perform_login").defaultSuccessUrl("/homepage", true).and().httpBasic();
		http.csrf().disable();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new CustomLogoutSuccessHandler();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
