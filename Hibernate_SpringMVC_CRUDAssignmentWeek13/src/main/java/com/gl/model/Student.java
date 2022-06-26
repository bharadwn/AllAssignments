/**
 * Model Class for Student
 */
package com.gl.model;


import javax.persistence.*;

/**
 * @author Nandita
 * 
 * Entity, which will help use create students table in database 
 * Annotating the class with Hibernate Annotations
 * 
 */
@Entity
@Table (name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fullname")
	private String fullName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="country")
	private String country;
	
	
	/**
	 * Constructor for Student
	 */
	public Student() {
	}
		
	/**
	 * @param fullName
	 * @param department
	 * @param country
	 */
	public Student(String fullName, String department, String country) {
		
		this.fullName = fullName;
		this.department = department;
		this.country = country;
	}

	/**
	 * @param id
	 * @param fullName
	 * @param department
	 * @param country
	 */
	public Student(int id, String fullName, String department, String country) {
		
		this.id = id;
		this.fullName = fullName;
		this.department = department;
		this.country = country;
	}

	/**
	 * Converts all the element details into String
	 */
	@Override	
	public String toString() {
		return "Student [fullName=" + fullName + ", department=" + department + ", country=" + country + "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * @param id : input id ID
	 * @return student: this student instance of the specified ID
	 */
	public Student getStudentForID(int id) {
		if (this.id == id) {
			return this;
		}
		return null;
	}


}
