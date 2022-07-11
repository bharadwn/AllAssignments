package com.greatLearning.studentREST.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatLearning.studentREST.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.greatLearning.studentREST.model.User user = userRepository.getUserByUserName(username);
		
		if (user == (null)) {
			throw new UsernameNotFoundException("No User record found");
		}
		System.out.println("--user.getUsername()--"+user.getUsername()+"--user.getPassword()--"+user.getPassword()+"roles"+user.getRoles());
		return new MyUserDetails(user);
	}
}
