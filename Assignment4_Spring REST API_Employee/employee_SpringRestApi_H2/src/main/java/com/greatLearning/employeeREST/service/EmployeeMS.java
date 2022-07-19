package com.greatLearning.employeeREST.service;

import java.util.List;

import com.greatLearning.employeeREST.model.Employee;

public interface EmployeeMS {
	public List<Employee> findAll();

	public Employee findById(int id);

	public Employee save(Employee employee);// also update

	public void deleteById(int id);

	public List<Employee> findAllByFirstName(String aFirstName);

	public List<Employee> sortedListByFirstName(String order);

	public List<Employee> sortedListByID(String order);
}
