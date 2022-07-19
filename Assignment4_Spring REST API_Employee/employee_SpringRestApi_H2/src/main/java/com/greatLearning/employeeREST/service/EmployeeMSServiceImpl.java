package com.greatLearning.employeeREST.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatLearning.employeeREST.model.Employee;
import com.greatLearning.employeeREST.repository.EmployeeRepository;

@Service
public class EmployeeMSServiceImpl implements EmployeeMS {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		} else
			throw new IllegalArgumentException("Did not find the Employee by that ID, Please provide ID in the DB.");
	}

	@Override
	public Employee save(Employee employee) {
		if (employee.getId() == 0)
			return employeeRepository.save(employee);
		else {
			if (employeeRepository.findById(employee.getId()) != null)
				return employeeRepository.save(employee);
			else
				throw new IllegalArgumentException("Could not find the Employee with that ID, so cannot update.");
		}
	}

	@Override
	public void deleteById(int id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			employeeRepository.deleteById(id);
			System.out.println("Deleted employee record by ID :"+id);
		} else
			throw new IllegalArgumentException("Did not find the Employee by that ID, Please provide ID in the DB.");
	}

	@Override
	public List<Employee> findAllByFirstName(String aFirstName) {
		Employee employeeWithThatFirstName = new Employee();
		employeeWithThatFirstName.setFirstName(aFirstName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.ignoreCase())
				.withIgnorePaths("id", "lastName", "email");
		Example<Employee> example = Example.of(employeeWithThatFirstName, exampleMatcher);

		List<Employee> employees = employeeRepository.findAll(example);
		return employees;
	}

	@Override
	public List<Employee> sortedListByFirstName(String order) {
		System.out.println("Order is:::----------" + order);
		Direction sortOrder = Sort.Direction.fromString(order);
		System.out.println("Sort.Direction.fromString(order)" + sortOrder);
		List<Employee> employees = employeeRepository.findAll(Sort.by(sortOrder, "firstName"));
		return employees;
	}

	@Override
	public List<Employee> sortedListByID(String order) {
		System.out.println("Order is:::----------" + order);
		// List<Employee> employees =
		// employeeRepository.findAll(Sort.by(Sort.Direction.fromString(order),"id"));
		Direction sortOrder = Sort.Direction.fromString(order);
		System.out.println("Sort.Direction.fromString(order)" + sortOrder);
		List<Employee> employees = employeeRepository.findAll(Sort.by(sortOrder, "id"));
		return employees;
	}

}
