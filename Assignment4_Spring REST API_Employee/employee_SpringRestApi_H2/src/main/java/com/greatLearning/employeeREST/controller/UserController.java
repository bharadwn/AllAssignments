package com.greatLearning.employeeREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.employeeREST.model.Role;
import com.greatLearning.employeeREST.model.User;
import com.greatLearning.employeeREST.service.UserDetailsServiceImpl;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/uds")
public class UserController {
	@Autowired
	// @Qualifier ("UserDetailsServiceImpl")
	private UserDetailsService userDetailsService;

	/**
	 * 1.Your application should be able to add roles in the database dynamically in
	 * the db.
	 * 
	 * @param role
	 * @return
	 */
	@PostMapping("/newRole")
	public Role saveRole(@RequestBody Role role) {
		return ((UserDetailsServiceImpl) userDetailsService).saveRole(role);
	}

	/**
	 * 1.Your application should be able to add roles in the database dynamically in
	 * the db.
	 * 
	 * @param user
	 * @param passwordEncoder
	 * @return
	 */
	@PostMapping("/addUser")
	public User saveUser(@RequestBody User user, @ApiIgnore BCryptPasswordEncoder passwordEncoder) {
		return ((UserDetailsServiceImpl) userDetailsService).saveUser(user, passwordEncoder);
	}
}
