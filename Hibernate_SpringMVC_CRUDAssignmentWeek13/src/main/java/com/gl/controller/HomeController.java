/**
 * This is a full implementation
 * 
 * First Link provides addition,
 * Second Link provides addition, deletion, and update facilities.
 * 
 */
package com.gl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.model.Student;
import com.gl.service.StudentPortal;

@Controller
public class HomeController {
	
	@Autowired
	private StudentPortal studentPortal;

	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
	    List<Student> students = studentPortal.getAllStudentRecords();
	    theModel.addAttribute("students", students);
	return "list-students";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("student") Student aStudent) {
		studentPortal.insertStudentRecord(aStudent);
		return "redirect:/list";
	}
    
	//Somehow I tried many ways of DeleteMapping but its not working for me
	
	//Below method works fine. 
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("studid") int theId) {
    	this.studentPortal.deleteStudentRecord(theId);
        return "redirect:/list";
    }
    
    
    //Somehow the sending request JSP is only sending GET and POST methods
    //So I am not able to implement the PutMapping and DeleteMapping
	
    @GetMapping("/updateForm/{id}")
    public String updateStudentById(@PathVariable int id, Model theModel) throws Exception {
    	System.out.println("id is:"+id);
    	Optional<Student> aStudent = studentPortal.findByID(id);
    	if (aStudent.isPresent()) {
    		// add student object to the model
    		theModel.addAttribute("student", aStudent.get());
    		theModel.addAttribute("id", aStudent.get().getId());
    	} else {
    		throw new Exception("Something went wrong, cannot find the student record.");
    	}
    	return "update-form";
    }
    
    

    @GetMapping("/updateForm/processUpdateForm")
    public String processUpdateForm(@RequestParam("id") int theId, @ModelAttribute("student") Student newStudentdeets)  {
    
		// log the input data
		//System.out.println("studid is"+theId);

			studentPortal.updateAndSaveStudentRecord(newStudentdeets, theId);
		
		return "redirect:/list";
	}
   

    @RequestMapping("/showForm")
	public String showForm(Model theModel, @ModelAttribute("student") Student aStudent) {
		// create a student object

			Student	student = new Student();

		// add student object to the model
		theModel.addAttribute("student", student);

		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent ) throws Exception {
		// log the input data
		System.out.println(theStudent.getId()+"theStudent: " + theStudent.getFullName() 
		+ " theStudent.getCountry()  " + theStudent.getCountry() + 
		" theStudent.getFullName() "  + theStudent.getDepartment());
		
		studentPortal.insertStudentRecord(theStudent);

		return "redirect:/list";
	}
    
	
}
