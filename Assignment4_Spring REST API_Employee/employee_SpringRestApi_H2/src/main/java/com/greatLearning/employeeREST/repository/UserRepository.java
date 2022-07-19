package com.greatLearning.employeeREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatLearning.employeeREST.model.Role;
import com.greatLearning.employeeREST.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT u FROM User u where u.username=?1")
	public User getUserByUserName(String username);

	public Role save(Role role);

	@SuppressWarnings("unchecked")
	public User save(User user);
}
