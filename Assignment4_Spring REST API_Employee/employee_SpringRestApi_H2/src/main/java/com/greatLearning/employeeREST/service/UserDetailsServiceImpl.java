package com.greatLearning.employeeREST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatLearning.employeeREST.model.Role;
import com.greatLearning.employeeREST.model.User;
import com.greatLearning.employeeREST.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUserName(username);

		if (user == (null)) {
			throw new UsernameNotFoundException("No User record found");
		}
		System.out.println("--user.getUsername()--" + user.getUsername() + "--user.getPassword()--" + user.getPassword()
				+ "roles" + user.getRoles());
		return new MyUserDetails(user);
	}

	public Role saveRole(Role role) {
		return userRepository.save(role);
	}

	public User saveUser(User user, BCryptPasswordEncoder passwordEncoder) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
