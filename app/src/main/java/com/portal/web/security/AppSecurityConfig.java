package com.portal.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.portal.web.security.handler.CustomAccessDeniedHandler;
import com.portal.web.security.handler.CustomAuthenticationFailureHandler;
import com.portal.web.security.handler.CustomLogoutSuccessHandler;


//public class AppSecurityConfig{
//	
//}

@Configuration
@EnableWebSecurity
//@Profile("!https")
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	public AppSecurityConfig(){
		super();
	}

	/**
	 * This method will configure in memory authentication manager with users and
	 * roles.
	 */
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
				.and().withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER").and()
				.withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");

	}
	
	@Override
    protected void configure(final HttpSecurity http) throws Exception {
		// @formatter:off
        http
          .csrf().disable()
          .authorizeRequests()
          .antMatchers("/admin/**").hasRole("ADMIN")
          .antMatchers("/anonymous*").anonymous()
          .antMatchers("/login*").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .loginPage("/login.html")
          .loginProcessingUrl("/perform_login")
          .defaultSuccessUrl("/homepage.html", true)
          //.failureUrl("/login.html?error=true")
          .failureHandler(authenticationFailureHandler())
          .and()
          .logout()
          .logoutUrl("/perform_logout")
          .deleteCookies("JSESSIONID")
          .logoutSuccessHandler(logoutSuccessHandler());
        // @formatter:on
    }
	
	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//        .antMatchers("/login")
//            .permitAll()
//        
//        .antMatchers("/**")
//            .hasAnyRole("ADMIN", "USER")
//        .and()
//            .formLogin()
//            .loginPage("/login")
//            .defaultSuccessUrl("/home")
//            .failureUrl("/login?error=true")
//            .permitAll()
//        .and()
//            .logout()
//            .logoutSuccessUrl("/login?logout=true")
//            .invalidateHttpSession(true)
//            .permitAll()
//        .and()
//            .csrf()
//            .disable(); 
//    }
	
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

