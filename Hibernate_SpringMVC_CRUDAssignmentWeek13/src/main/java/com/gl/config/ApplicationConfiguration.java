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

import com.gl.dao.StudentRepository;
import com.gl.service.StudentPortalImpl;

@Configuration
@ComponentScan("com.gl")
public class ApplicationConfiguration {
	
	@Bean
	public StudentRepository studentRepository() {
		return new StudentRepository();
	}
	
	@Bean 
	public StudentPortalImpl studentPortalImpl() {
		return new StudentPortalImpl(studentRepository());
	}
	
}
