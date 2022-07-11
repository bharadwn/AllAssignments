package com.greatLearning.studentREST.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigurationWithJDBC extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasource).withDefaultSchema()
				.withUser(User.withUsername("Nandita").password(getPasswordEncoder().encode("nandita")).roles("ADMIN"))
				.withUser(User.withUsername("Pooja").password(getPasswordEncoder().encode("pooja")).roles("USER"));
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		// return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		//		http.csrf().disable().authorizeRequests().anyRequest().permitAll().and().formLogin();

		http.csrf().disable().authorizeRequests()
			.antMatchers("/delete").hasRole("ADMIN")
			.antMatchers("/list", "/saveStudent", "/showForm","/updateForm","/processForm","/403")
			.hasAnyRole("ADMIN", "USER")
			// .antMatchers("/").permitAll().and().formLogin();
			//.antMatchers("/logout").permitAll()
			.antMatchers("/").authenticated()
			.and().exceptionHandling().accessDeniedPage("/403")
			.and().formLogin();

	}

}
