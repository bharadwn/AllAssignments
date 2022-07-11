package com.greatLearning.studentREST.config;

import com.greatLearning.studentREST.service.UserDetailsServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		//return NoOpPasswordEncoder.getInstance();
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
		
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//auth.authenticationProvider(authenticationProvider());
		auth.userDetailsService(userDetailsService());
	}
 /*   
	protected void configure(HttpSecurity http) throws Exception { 
			//http.csrf().disable().authorizeRequests().anyRequest().permitAll().and().formLogin();
		http.authorizeRequests()//.anyRequest().authenticated()
		.antMatchers("/delete").hasAuthority("ADMIN")//.hasRole("ADMIN")
		.antMatchers("/list", "/saveStudent", "/showForm","/updateForm","/processForm","/403").hasAnyAuthority("USER","ADMIN")//.hasAnyRole("ADMIN", "USER")
		.antMatchers("/").authenticated()
		.and()
		.formLogin().loginProcessingUrl("/login").successForwardUrl("/list").permitAll()
		.and()
		.logout().logoutSuccessUrl("/login").permitAll()
		.and().exceptionHandling().accessDeniedPage("/403")
		
		.and().cors().and().csrf().disable();
		
		/*
		http.csrf().disable().authorizeRequests()
		.antMatchers("/delete").hasRole("ADMIN")
		.antMatchers("/list", "/saveStudent", "/showForm","/updateForm","/processForm","/403")
		.hasAnyRole("ADMIN", "USER")
		// .antMatchers("/").permitAll().and().formLogin();
		//.antMatchers("/logout").permitAll()
		.antMatchers("/").authenticated()
		.and().exceptionHandling().accessDeniedPage("/403")
		.and().formLogin();
		

  http.authorizeRequests()
  
  //admin endpont can access only ADMIN ROLE
  .antMatchers("/delete").hasRole("ADMIN")
  
  //user endpoint can access ADMIN and USER ROLES .antMatchers("/list",
  "/saveStudent",
  "/showForm","/updateForm","/processForm","/403").hasAnyRole("ADMIN", "USER")
  
  //can access all users .antMatchers("/").permitAll()
  
  .and().formLogin();
 
	}*/
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/list", "/saveStudent", "/showForm","/updateForm","/processForm","/403").hasAnyAuthority("USER","ADMIN")
		.antMatchers("/delete").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginProcessingUrl("/login").permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403")
		.and()
		.cors().and().csrf().disable();
		
	}
}
