/**
 * Model Class for Student
 */
package com.greatLearning.studentREST.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Nandita
 * 
 * Entity, which will help use create students table in database 
 * Annotating the class with Hibernate Annotations
 * 
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="course")
	private String course;
	
	@Column(name="country")
	private String country;

}
