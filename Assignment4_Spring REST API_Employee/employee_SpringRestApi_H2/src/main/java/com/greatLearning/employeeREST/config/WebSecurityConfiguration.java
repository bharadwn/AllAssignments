package com.greatLearning.employeeREST.config;

import com.greatLearning.employeeREST.service.UserDetailsServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
		// return NoOpPasswordEncoder.getInstance();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(getPasswordEncoder());
		return authenticationProvider;

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
		// auth.userDetailsService(userDetailsService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/","/list", "/saveStudent", "/showForm","/updateForm","/processForm","/403").hasAnyAuthority("USER","ADMIN")
//		.antMatchers("/delete").hasAuthority("ADMIN")
//		.anyRequest().authenticated()
//		.and()
//		.formLogin().loginProcessingUrl("/login").permitAll()
//		.and()
//		.logout().permitAll()
//		.and()
//		.exceptionHandling().accessDeniedPage("/403")
//		.and()
//		.cors().and().csrf().disable();

		//System.out.println("Am inside security config for http");
		http.authorizeRequests().antMatchers("/uds/newRole", "/uds/addUser").hasAuthority("UDS_ADMIN")
			.antMatchers("/api/delete", "/api/update", "/api/employees", "/api/delete", "/api/employees/**",
					"/api/delete/**", "/api/search/**")
			.hasAnyAuthority("USER", "ADMIN")// need not add sort as it comes after employees
			.antMatchers("/api/add", "/api/add/").hasAuthority("ADMIN").anyRequest().authenticated().and()
			.formLogin().loginProcessingUrl("/login").defaultSuccessUrl("/api", false).and().cors().and().csrf()
			.disable();
	}
}
