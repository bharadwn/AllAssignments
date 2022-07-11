/**
 * 
 */
package com.greatLearning.studentREST.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.studentREST.model.Student;
import com.greatLearning.studentREST.repository.StudentRepository;

/**
 * @author Nandita
 * DI and IOC added here
 */
@Service
public class StudentPortalImpl implements StudentPortal {
	
	@Autowired
	private StudentRepository studentRepo;
//	
//	
//	/**
//	 * @param studentRepo
//	 */
//	public StudentPortalImpl(StudentRepository studentRepo) {
//		this.studentRepo = studentRepo;
//	}
//
//	@Override
//	public void insertStudentRecord(Student aStudent) {
//		//this.studentRepo.insertStudentRecord(aStudent);
//		this.studentRepo.updateAndSaveStudentRecord(aStudent, 0 );
//		
//	}
//
//	@Override
//	public void updateAndSaveStudentRecord(Student aStudent , int id) {
//		this.studentRepo.updateAndSaveStudentRecord(aStudent, id );
//		
//	}
//
//	@Override
//	public void deleteStudentRecord(int id) {
//		this.studentRepo.deleteStudentRecord(id);
//		
//	}
//
//	@Override
//	public List<Student> getAllStudentRecords() {
//		List<Student> students =this.studentRepo.getAllStudentRecords();
//		return students;
//	}
//
//	@Override
//	public Optional<Student> findByID(int aID) {
//		Optional<Student> student = this.studentRepo.findByID(aID);
//		return student;
//	}
//
//	@Override
//	public void insertStudentRecord(com.greatLearning.studentREST.model.Student aStudent) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void updateAndSaveStudentRecord(com.greatLearning.studentREST.model.Student aStudent, int id) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public List<Student> getAllStudentRecords() {
		List<Student> students = studentRepo.findAll();
		return students;
	}


	@Override
	public void deleteStudentRecord(int theId) {
		studentRepo.deleteById(theId);			
	}

	@Override
	public Student findById(int theId) {
		Student student = studentRepo.findById(theId).get();
		return student;
	}

	@Override
	public void saveStudentRecord(Student aStudent) {
		studentRepo.save(aStudent);				
	}

}
