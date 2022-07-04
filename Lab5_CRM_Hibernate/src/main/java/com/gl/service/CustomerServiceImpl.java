package com.gl.service;

import java.util.List;
import java.util.Optional;

import com.gl.dao.CRMRepository;
import com.gl.model.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	private CRMRepository customerRepository;

	/**
	 * @param customerRepository
	 * DI and IoC
	 */
	public CustomerServiceImpl(CRMRepository customerRepository) {
		
		this.customerRepository = customerRepository;
	}

	/**
	 *
	 */
	@Override
	public void insertCustomerRecord(Customer aCustomer) {
		this.customerRepository.insertCustomerRecord(aCustomer);
		
	}

	@Override
	public void updateAndSaveCustomerRecord(Customer aCustomer, int id) {
		this.customerRepository.updateAndSaveCustomerRecord(aCustomer, id);
		
	}

	@Override
	public void deleteCustomerRecord(int id) {
		this.customerRepository.deleteCustomerRecord(id);
		
	}

	@Override
	public List<Customer> getAllCustomerRecords() {
		return this.customerRepository.getAllCustomerRecords();
		
	}

	@Override
	public Optional<Customer> findByID(int aID) {		
		return this.customerRepository.findByID(aID);
	}
	

}
