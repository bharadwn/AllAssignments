package com.greatLearning.studentREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatLearning.studentREST.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
