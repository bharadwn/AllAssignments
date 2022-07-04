package com.gl.dao;

import java.util.List;
import java.util.Optional;

import com.gl.model.Customer;

public interface CRMRepository {

	/**
	 * Inserts a customer record
	 * @param aCustomer : a customer record details to be added to the database.
	 */
	public void insertCustomerRecord(Customer aCustomer);

	/**
	 * Updates a Customer record
	 * @param aCustomer - customer record with new customer details to be updated
	 * @param id - id of the customer to be updated
	 */
	public void updateAndSaveCustomerRecord(Customer aCustomer, int id);

	/**
	 * Deletes a Students record
	 * @param id : id of the customer record to be deleted
	 */
	public void deleteCustomerRecord(int id);

	/**
	 * Reads all customer records in the database.
	 * @return Returns list of customer records
	 */

	public List<Customer> getAllCustomerRecords();

	public Optional<Customer> findByID(int aID);

}