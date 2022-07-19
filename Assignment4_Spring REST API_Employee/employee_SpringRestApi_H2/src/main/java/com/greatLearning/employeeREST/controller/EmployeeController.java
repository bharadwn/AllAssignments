package com.greatLearning.employeeREST.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.greatLearning.employeeREST.model.Employee;
import com.greatLearning.employeeREST.service.EmployeeMS;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ResponseBody
//@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeMS employeeMSService;

	@ApiIgnore
	@GetMapping("/")
	public List<Employee> list() {

		List<Employee> employees = employeeMSService.findAll();
		return employees;
	}

	@ApiIgnore
	@GetMapping("")
	public List<Employee> listAll() {

		List<Employee> employees = employeeMSService.findAll();
		return employees;
	}

	/**
	 * 
	 * 3. Your application should provide an endpoint to list all the employees
	 * stored in the database.
	 * 
	 * 
	 */
	@GetMapping("/employees")
	public List<Employee> findAll(@ApiIgnore Principal user) {
		System.out.println("principalUser ::" + user.getName());
		List<Employee> employees = employeeMSService.findAll();
		return employees;
	}

	/**
	 * 4. Your application should provide an end point to save a new employee record
	 * 
	 * @param employee : send employee if want to update
	 */
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee, @ApiIgnore Principal user) {
		employee.setId(0);
		System.out.println("principalUser ::" + user.getName());
		return employeeMSService.save(employee);// same method for save /update
	}

	/**
	 * 5. Your application should provide endpoint to fetch or get an employee
	 * record specifically based on the id of that employee-
	 * 
	 */
	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id) {
		System.out.println(id);
		Employee employee = employeeMSService.findById(id);
		return employee;
	}

	/***
	 * 6. Your application should provide an endpoint to update an existing employee
	 * record with the given updated json object.
	 */
	@PutMapping("/update")
	public Employee update(@RequestBody Employee employee) {
		return employeeMSService.save(employee);// same method for save /update
	}

	/**
	 * 7. Your application should provide an endpoint to fetch an employee by
	 * his/her first name and if found more than one record then list them all-
	 * 
	 * cannot have the same url as findbyID so changed it to delete
	 */
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		System.out.println(id);
		employeeMSService.deleteById(id);
	}

	/**
	 * 8. Your application should be able to list all employee records sorted on
	 * their first name in either ascending order or descending order .
	 * 
	 * Currently , its ignoring case of the first Name
	 * 
	 * 
	 */
	@GetMapping("/search/{firstName}")
	public List<Employee> searchByFirstName(@PathVariable(required = true, name = "firstName") String firstName) {
		System.out.println(firstName);
		return employeeMSService.findAllByFirstName(firstName);
	}

	/**
	 * 9. Your application should be able to list all employee records sorted on
	 * their first name in either ascending order or descending order .
	 * 
	 * 
	 * Ordered on CApitals first and then lowercase next
	 */
	@GetMapping("/employees/sort")
	public List<Employee> sortByFirstName(@RequestParam(defaultValue = "asc", name = "order") String order) {
		return employeeMSService.sortedListByFirstName(order);
	}

	/**
	 * 
	 * EXTRA API 10. Your application should be able to list all employee records
	 * sorted on ID their first name in either ascending order or descending order .
	 */
	@GetMapping("/employees/sortID")
	public List<Employee> sortByID(@RequestParam(defaultValue = "asc", name = "order") String order) {
		return employeeMSService.sortedListByID(order);
	}

	/*
	 * 
	 * @GetMapping("/info") public Employee getInfo() { Employee employee = new
	 * Employee(); employee.setFirstName("Nandita"); employee.setLastName(" KB");
	 * employee.setEmail("nandita@gmail.com"); return employee;
	 * 
	 * }
	 * 
	 * 
	 * @PostMapping("/custominfo") public Employee customInfo(String firstName,
	 * String lastName, String email) { Employee employee = new Employee();
	 * employee.setFirstName(firstName); employee.setLastName(lastName);
	 * employee.setEmail(email); return employee; }
	 */
}
