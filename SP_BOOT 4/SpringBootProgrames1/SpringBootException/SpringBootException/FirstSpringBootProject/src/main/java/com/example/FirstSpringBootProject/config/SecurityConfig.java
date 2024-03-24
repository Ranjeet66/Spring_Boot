package com.example.FirstSpringBootProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	 
	  @Override protected void configure(AuthenticationManagerBuilder build) throws
	  Exception {
	  
	  build.inMemoryAuthentication().withUser("ducat").password("ducat").roles("USER").
	  and().withUser("manish") .password("manish").roles("ADMIN");
	  
	  
	 
	  }
	  
	  @Bean public PasswordEncoder getPasswordEncoder() { return
	  NoOpPasswordEncoder.getInstance(); }
	  
	  @Override protected void configure(HttpSecurity http) throws Exception {
	 
	  http.authorizeRequests().antMatchers("/greet").hasRole("ADMIN").antMatchers(
	  "/listOfUniversities") .hasAnyRole("USER",
	  "ADMIN").antMatchers("/").permitAll().and().formLogin();
	  
	 
	 
	  }
	  
	 
}
