/**
 * 
 * This is ainitial implementation from the videos week13
 */
package com.gl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.model.Student;
import com.gl.service.StudentPortal;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentPortal studentPortal;
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// create a student object
		Student theStudent = new Student();

		// add student object to the model
		theModel.addAttribute("student", theStudent);

		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		// log the input data
		System.out.println("theStudent: " + theStudent.getFullName() 
		+ " theStudent.getCountry()  " + theStudent.getCountry() + 
		" theStudent.getFullName() "  + theStudent.getDepartment());
		studentPortal.insertStudentRecord(theStudent);
		return "student-confirmation";
	}

}
