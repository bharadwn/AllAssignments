/**
 * Student service portal provides CRUD operations for the student table in the database
 */
package com.greatLearning.studentREST.service;

import java.util.List;

import com.greatLearning.studentREST.model.Student;


/**
 * @author Nandita
 *
 */
public interface StudentPortal {	
	public void saveStudentRecord(Student aStudent);

	public void deleteStudentRecord(int id);
	
	public List<Student> getAllStudentRecords();	

	public Student findById(int theId);

}
