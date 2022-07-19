//package com.greatLearning.employeeREST.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfigurationWithJDBC extends WebSecurityConfigurerAdapter {
//	@Autowired
//	DataSource datasource;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(datasource).withDefaultSchema()
//				.withUser(User.withUsername("Nandita").password(getPasswordEncoder().encode("nandita")).roles("ADMIN"))
//				.withUser(User.withUsername("Pooja").password(getPasswordEncoder().encode("pooja")).roles("USER"));
//	}
//
//	@Bean
//	PasswordEncoder getPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/h2-console/**");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////		http.csrf().disable();
////		http.cors().disable();
////		http.authorizeRequests()
////			.antMatchers("/api/save").hasRole("ADMIN")
////			.antMatchers("/api/delete", "/api/update", "/api/employees", "/api/delete",
////						"/api/employees/**", "/api/delete/**", "/api/search/**")
////				.hasRole("USER")// need not add sort as it comes after employees
////			.antMatchers("/").authenticated().and().formLogin();
//		System.out.println("Am inside security config for http");
//		http.authorizeRequests()
//				.antMatchers("/api/delete", "/api/update", "/api/employees", "/api/delete", "/api/employees/**",
//						"/api/delete/**", "/api/search/**")
//				.hasAnyRole("USER", "ADMIN")// need not add sort as it comes after employees
//				.antMatchers("/api/add", "/api/add/").hasRole("ADMIN").anyRequest().authenticated().and().formLogin()
//				.loginProcessingUrl("/login").defaultSuccessUrl("/api", false).and().cors().and().csrf().disable();
//
////		http.csrf().disable().authorizeRequests()
////			.antMatchers("/delete").hasRole("ADMIN")
////			.antMatchers("/list", "/saveStudent", "/showForm","/updateForm","/processForm","/403")
////			.hasAnyRole("ADMIN", "USER")
////			// .antMatchers("/").permitAll().and().formLogin();
////			//.antMatchers("/logout").permitAll()
////			.antMatchers("/").authenticated()
////			.and().exceptionHandling().accessDeniedPage("/403")
////			.and().formLogin();
//
//	}
//
//}
