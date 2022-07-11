
package com.greatLearning.studentREST.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatLearning.studentREST.model.Student;
import com.greatLearning.studentREST.service.StudentPortal;

@Controller
public class StudentController {
	@Autowired
	private StudentPortal studentPortal;

	@RequestMapping("/")
	public String showPage() {
		// return "main-menu";
		// return "list-students";
		return "redirect:/list";
	}

	@GetMapping("/list")
	public String listCustomers(Model theModel, Principal user) {
		List<Student> students = studentPortal.getAllStudentRecords();
		theModel.addAttribute("students", students);
		theModel.addAttribute("principalU",user.getName());
		return "student-list";
	}

	@PostMapping("/saveStudent")
	public String saveCustomer(@ModelAttribute("student") Student aStudent) {
		studentPortal.saveStudentRecord(aStudent);
		return "redirect:/list";
	}

	// Somehow I tried many ways of DeleteMapping but its not working for me

	// Below method works fine.
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("studentid") int theId) {
		this.studentPortal.deleteStudentRecord(theId);
		return "redirect:/list";
	}



	@GetMapping("/updateForm/{id}")
	public String updateStudentById(@PathVariable int id, Model theModel) {
		System.out.println("id is:" + id);
		Student aStudent = studentPortal.findById(id);
		
		// add student object to the model
		theModel.addAttribute("student", aStudent);
		theModel.addAttribute("id", aStudent.getId());

		return "update-form";
	}

	@GetMapping("/updateForm/processUpdateForm")
	public String processUpdateForm(@RequestParam("id") int theId, @ModelAttribute("student") Student newStudentdeets) {
		// log the input data
		// System.out.println("student id is"+theId);
		//studentPortal.saveStudentRecord(newStudentdeets, theId);
		studentPortal.saveStudentRecord(newStudentdeets);

		return "redirect:/list";
	}

	@RequestMapping("/showForm")
	public String showForm(Model theModel, @ModelAttribute("student") Student aStudent) {
		// create a student object
		Student student = new Student();

		// add student object to the model
		theModel.addAttribute("student", student);

		return "add-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) throws Exception {
		// log the input data
		System.out.println("ID of Student is :" + theStudent.getId() + "Student Firstname " + theStudent.getFirstName()
				+ " theStudent.getCountry()  " + theStudent.getCountry() + " theStudent.getLastName() "
				+ theStudent.getLastName() + " Student getCourse()" + theStudent.getCourse());

		studentPortal.saveStudentRecord(theStudent);

		return "redirect:/list";
	}
	
	/*
	 * @RequestMapping("/logout") public String logOut() { return "/logout"; }
	 */
	
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission for this action. Login as admin for more priviledges");
		} else {
			model.addObject("msg", 
			"You do not have permission for this action. Login as admin for more priviledges");
		}
		System.out.println("user is:"+user.getName());
		model.addObject("principalU",user.getName());
		model.setViewName("403");
		return model;
	}

}
