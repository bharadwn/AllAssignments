/**
 * Student service portal provides CRUD operations for the student table in the database
 */
package com.gl.service;

import java.util.List;
import java.util.Optional;

import com.gl.model.Student;

/**
 * @author Nandita
 *
 */

public interface StudentPortal {
	
	public void insertStudentRecord(Student aStudent);

	public void updateAndSaveStudentRecord(Student aStudent, int id);
	
	public void deleteStudentRecord(int id);
	
	public List<Student> getAllStudentRecords();	
	
	public Optional<Student> findByID(int aID) ;

}
