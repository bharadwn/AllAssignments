/**
 * Problem Statement:
In College fest, Students want to take registrations for a Debate event and want to keep track of student details based on the department. Help the students to create a table with the help of Spring, MVC, Hibernate ORM to perform CRUD operations on the table.
Sample Table:
Student Id
Name
Department
Country
1
Suresh
B.Tech
India
2
Muri
B.Arch
Canada
3
Daniel
B.Tech
New Zealand
4
Tanya
B.Com
USA
Create a Dynamic web project and make sure that the following operations can be performed.
1. Insert new records into the table.
2. Update existing records into the table.
3. Delete existing records from the table.
4. Print all records from the table.

 */
package com.gl.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gl.model.Student;
import com.gl.service.StudentPortal;
import com.gl.service.StudentPortalImpl;

/**
 * @author Nandita
 * 
 * Everything works fine. -HIbernate ORM, Mappings, Entity, Annotations
 * 
 * When the web app is run on the server, you can see the JSP , a little HTML and CSS from w3schools. 
 * So you need net connection. But JSP works fine without any CSS even if not internet.
 * 
 * CRUD operations are implemented in the file StudentRepository.java
 * Student.java is the Entity.(to create the table students table in the database
 * 
 * Spring MVC are provided in Model package, View Folder in WEB-INF, and controller package
 * 
 * Hibernate ORM is implemented in Student.java
 * 
 * 
 * Please create a MYSQL Database by name 'hibernate_spring_crud' for this code to work.
 * 
 * Also run as application to find some database entries before you run on server.
 * 
 * USING JDK 1.8
 * 
 */
public class Client {
	
	private ApplicationContext appContext;

	public Client() {		
		appContext= new AnnotationConfigApplicationContext(com.gl.config.ApplicationConfiguration.class);
		
	}

	/**
	 * @param args
	 * 
	 * 1. Insert new records into the table.
	 * 2. Update existing records into the table.
	 * 3. Delete existing records from the table.
	 * 4. Print all records from the table.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Client client = new Client();
		client.addStudents();
		client.updateStudents();
		client.deleteStudents();
		client.getAllStudents();

	}

	/*
	 * Print all records from the table.
	 */
	private void getAllStudents() {				
		StudentPortal studentPortal = appContext.getBean(StudentPortalImpl.class);
		List<Student>  students= studentPortal.getAllStudentRecords();//Pass Check		
		for (Student student :students) {
			System.out.println(" "+student);
		}
	}

	/*
	 * Delete existing records from the table.
	 */
	private void deleteStudents() {
		StudentPortal studentPortal = appContext.getBean(StudentPortalImpl.class);
		studentPortal.deleteStudentRecord( 4);//Pass Check
		
		studentPortal.deleteStudentRecord( 100);//Fail Check
	}

	/*
	 * Update existing records into the table.
	 */
	private void updateStudents() {

		Student updateStudent= new Student("Suresh","Btech","USA");
		StudentPortal studentPortal = appContext.getBean(StudentPortalImpl.class);
		studentPortal.updateAndSaveStudentRecord(updateStudent, 1);//Pass Check
		
		Student updateStudent1 = new Student("Ramya","B.com","USA");
		studentPortal.updateAndSaveStudentRecord(updateStudent1, 100);//Fail Check
	}

	/*
	 * Insert new records into the table.
	 */
	private void addStudents() {
		Student student1= new Student("Suresh","Btech","India");
		Student student2= new Student("Muri","B.Arch","Canada");
		Student student3= new Student("Daniel","Btech","New Zealand");
		Student student4= new Student("Tanya","B.com","USA");
		
		StudentPortal studentPortal = appContext.getBean(StudentPortalImpl.class);
		
		studentPortal.insertStudentRecord(student1);
		studentPortal.insertStudentRecord(student2);
		studentPortal.insertStudentRecord(student3);
		studentPortal.insertStudentRecord(student4);
	
	}
	
}
