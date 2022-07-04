package com.gl.service;

import java.util.List;
import java.util.Optional;

import com.gl.model.Customer;

public interface CustomerService {
	
	public void insertCustomerRecord(Customer aCustomer);

	public void updateAndSaveCustomerRecord(Customer aCustomer, int id);
	
	public void deleteCustomerRecord(int id);
	
	public List<Customer> getAllCustomerRecords();	
	
	public Optional<Customer> findByID(int aID) ;
}
