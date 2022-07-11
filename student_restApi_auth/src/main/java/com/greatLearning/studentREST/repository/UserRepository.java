package com.greatLearning.studentREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatLearning.studentREST.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT u FROM User u where u.username=?1")
	public User getUserByUserName(String username);
}
