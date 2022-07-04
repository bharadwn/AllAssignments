/**
 * 
 * @author Nandita
 * I am configuring the spring boot the java beanway, it is creating the beans.xml in WEB-INF
 * 
 * 
 */
package com.gl.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.gl.dao.CustomerRepository;
import com.gl.service.CustomerServiceImpl;

@Configuration
@ComponentScan("com.gl")
public class ApplicationConfiguration {
	
	@Bean
	public CustomerRepository customerRepository() {
		return new CustomerRepository();
	}
	
	@Bean
	public CustomerServiceImpl customerServiceImpl() {
		return new CustomerServiceImpl(customerRepository());
	}
}
