
package com.gl.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gl.model.Student;

/**
 * 
 * @author Nandita
 * 
 */
/**
 * @author Nandita
 *Taking the Hibernate configurations in the hibernate.cfg.xml and not the spring way.
 *
 *Please configure your database setting in that.
 *
 *
 *Repository COmponent
 *
 */
@Repository
public class StudentRepository {
	private Session session;
	private SessionFactory factory;
	public StudentRepository() {
		
		// create session factory
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

	}
	

	/**
	 * Inserts a student record
	 * @param aStudent : a student record details to be added to the database.
	 */
	@Transactional
	public void insertStudentRecord(Student aStudent) {
		try {
			//  session
			session = factory.getCurrentSession();
			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(aStudent);
			System.out.println("Student Record : "+aStudent+" creation completed.");
			
			// commit transaction
			session.getTransaction().commit();
		}  catch (Exception e){
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		}	
		
	}
	

	/**
	 * Updates a Student record
	 * @param aStudent - student record with new student details to be updated
	 * @param id - id of the student to be updated
	 */
	@Transactional
	public void updateAndSaveStudentRecord(Student aStudent, int id ) {
		if (id!=0) {
			Transaction transax=null;
			try {
				//  session
				session = factory.getCurrentSession();
				// start a transaction
				transax = session.beginTransaction();
			
				System.out.println("Student ID to update is"+ id);
				Student tempStudent = session.get(Student.class, id);
				
				if (tempStudent!=null) {
					tempStudent.setCountry(aStudent.getCountry());
					tempStudent.setDepartment(aStudent.getDepartment());
					tempStudent.setFullName(aStudent.getFullName());
					
					System.out.println(			"Updated student details ::::"+		tempStudent);
				
					//session.saveOrUpdate(tempStudent);
					session.update(tempStudent);
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Update Student Record "+ tempStudent.getFullName()+" Done!");
					
				} else {
					System.err.println("The student"+id+" is not available in the database. Please provide student ID that is in the DB.");
					transax.rollback();
				}		
			} catch (Exception e) {
				System.out.println(e.getMessage());
				transax.rollback();
			}
		} else {
			insertStudentRecord(aStudent);
		}
		
	}


	/**
	 * Deletes a Students record
	 * @param id : id of the student record to be deleted
	 */
	@Transactional
	public void deleteStudentRecord(int id) {
		try {
			//  session
			session = factory.getCurrentSession();
			// start a transaction
			session.beginTransaction();

			// fetching record where teacher id = 1
			Student deleteStudent = session.get(Student.class, id);
			if (deleteStudent!=null) {
				// deleting value using session.delete method
				System.out.println("Deleting student record : "+deleteStudent.getFullName());
				session.delete(deleteStudent);				

				// commit transaction
				session.getTransaction().commit();

				System.out.println("Delete student record of"+deleteStudent+"Completed!");
				
			} else {
				System.err.println("The student "+id+"is not available in the database. Please provide student ID that is in the DB.");
				session.getTransaction().rollback();				
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
			session.getTransaction().rollback();	
		}	
	}	

	/**
	 * Reads all student records in the database.
	 * @return Returns list of student records
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	
	public List<Student> getAllStudentRecords() {		
		List<Student> students = null;
		try {
			//  session
			session = factory.getCurrentSession();
			// start a transaction
			session.beginTransaction();

			// query Teachers
			students = session.createQuery("from Student").list();

			//display(students);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Fetch All Student records completed!");
		}  catch (Exception e){
			System.out.println(e.getMessage());
			session.getTransaction().rollback();	
		}	
		return students;
	}
	
	
	@Transactional
	public Optional<Student> findByID(int aID) {
		Transaction transax=null;
		try {
			//  session
			session = factory.getCurrentSession();
			// start a transaction
			transax = session.beginTransaction();

			System.out.println("Student ID to find is"+ aID);
			Student tempStudent = session.get(Student.class, aID);
			
			if (tempStudent!=null) {

				//commit transaction
				session.getTransaction().commit();
				System.out.println("Student Record is"+ tempStudent.getFullName()+".");
				
			} else {
				System.err.println("The student"+aID+" is not available in the database. Please provide student ID that is in the DB.");
				transax.rollback();
			}		
			return Optional.ofNullable(tempStudent);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			transax.rollback();
		}
		return Optional.empty();
	}
	
	/*
	private void display(List<Student> aStudents) {
		for (Student student : aStudents) {
			System.out.print(student+ "");
		}
	}
	*/
}
