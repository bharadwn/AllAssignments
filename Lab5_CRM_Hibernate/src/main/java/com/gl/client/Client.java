/**
 * 
You are required to create a Customer Relationship Management web application, where you
will be developing CRUD(Create Read Update Delete) functionality.
Note the following points while developing the application
→ The main page will display all the customers present in the database.
→ Customers will have following attributes
a) First Name
b) Last Name
c) Email
The
 */
package com.gl.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gl.model.Customer;
import com.gl.service.CustomerService;
import com.gl.service.CustomerServiceImpl;

/**
 * @author Nandita
 * 
 * Everything works fine. -HIbernate ORM, Mappings, Entity, Annotations
 * 
 * When the web app is run on the server, you can see the JSP , a little HTML and CSS from w3schools. 
 * So you need net connection. But JSP works fine without any CSS even if not internet.
 * 
 * CRUD operations are implemented in the file CustomerRepository.java
 * Customer.java is the Entity.(to create the table Customers table in the database
 * 
 * Spring MVC are provided in Model package, View Folder in WEB-INF, and controller package
 * 
 * Hibernate ORM is implemented in Customer.java * 
 * 
 * Please create a MYSQL Database by name 'customer_database' for this code to work.
 * 
 * Also run as application to find some database entries before you run on server.
 * 
 * USING JDK 1.8
 * 
 */
public class Client {
	
	private ApplicationContext applicationContext;

	public Client() {		
		applicationContext= new AnnotationConfigApplicationContext(com.gl.config.ApplicationConfiguration.class);
	}

	/**
	 * @param args
	 * 
	 * 1. Insert new records into the table.
	 * 2. Update existing records into the table.
	 * 3. Delete existing records from the table.
	 * 4. Print all records from the table.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Client client = new Client();
		client.addCustomers();
		client.updateCustomers();
		client.deleteCustomers();
		client.getAllCustomers();

	}

	/*
	 * Print all records from the table.
	 */
	public void getAllCustomers() {				
		CustomerService CustomerService = applicationContext.getBean(CustomerServiceImpl.class);
		List<Customer>  Customers= CustomerService.getAllCustomerRecords();//Pass Check		
		for (Customer Customer :Customers) {
			System.out.println(" "+Customer);
		}
	}

	/*
	 * Delete existing records from the table.
	 */
	public void deleteCustomers() {
		CustomerService CustomerService = applicationContext.getBean(CustomerServiceImpl.class);
		CustomerService.deleteCustomerRecord( 4);//Pass Check
		
		CustomerService.deleteCustomerRecord( 100);//Fail Check
	}

	/*
	 * Update existing records into the table.
	 */
	public void updateCustomers() {

		Customer updateCustomer= new Customer("Suresh","Btech","USA");
		CustomerService CustomerService = applicationContext.getBean(CustomerServiceImpl.class);
		CustomerService.updateAndSaveCustomerRecord(updateCustomer, 1);//Pass Check
		
		Customer updateCustomer1 = new Customer("Ramya","B.com","USA");
		CustomerService.updateAndSaveCustomerRecord(updateCustomer1, 100);//Fail Check
	}

	/*
	 * Insert new records into the table.
	 */
	public void addCustomers() {
		Customer Customer1= new Customer("Suresh","Btech","India");
		Customer Customer2= new Customer("Muri","B.Arch","Canada");
		Customer Customer3= new Customer("Daniel","Btech","New Zealand");
		Customer Customer4= new Customer("Tanya","B.com","USA");
		
		CustomerService CustomerService = applicationContext.getBean(CustomerServiceImpl.class);
		
		CustomerService.insertCustomerRecord(Customer1);
		CustomerService.insertCustomerRecord(Customer2);
		CustomerService.insertCustomerRecord(Customer3);
		CustomerService.insertCustomerRecord(Customer4);
	
	}
	
}
