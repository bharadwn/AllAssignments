/**
 * 
 */
package com.gl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.StudentRepository;
import com.gl.model.Student;

/**
 * @author Nandita
 * DI and IOC added here
 */
@Service
public class StudentPortalImpl implements StudentPortal {
	
	@Autowired
	private StudentRepository studentRepo;
	
	
	/**
	 * @param studentRepo
	 */
	public StudentPortalImpl(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public void insertStudentRecord(Student aStudent) {
		//this.studentRepo.insertStudentRecord(aStudent);
		this.studentRepo.updateAndSaveStudentRecord(aStudent, 0 );
		
	}

	@Override
	public void updateAndSaveStudentRecord(Student aStudent , int id) {
		this.studentRepo.updateAndSaveStudentRecord(aStudent, id );
		
	}

	@Override
	public void deleteStudentRecord(int id) {
		this.studentRepo.deleteStudentRecord(id);
		
	}

	@Override
	public List<Student> getAllStudentRecords() {
		List<Student> students =this.studentRepo.getAllStudentRecords();
		return students;
	}

	@Override
	public Optional<Student> findByID(int aID) {
		Optional<Student> student = this.studentRepo.findByID(aID);
		return student;
	}

}
