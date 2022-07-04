package com.gl.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.gl.model.Customer;
/**
 * @author Nandita
 *
 *
 *Please configure your database setting in that.
 *
 *
 *Repository Component
 *
 */
@Repository
public class CustomerRepository implements CRMRepository {
	
	private Session session;
	private SessionFactory factory;
//	@Autowired
//	private EntityManager entityManager;
//	
//	/**
//	 * @param entityManager
//	 * 
//	 * Dependency Injection also
//	 */
//	public CustomerRepository(EntityManager entityManager) {		
//		this.entityManager = entityManager;
//	}

	  public CustomerRepository() {
			// create session factory
			factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Customer.class)
					.buildSessionFactory();
	  
	  }
	 
	

	/**
	 * Inserts a customer record
	 * @param aCustomer : a customer record details to be added to the database.
	 */
	@Override
	@Transactional
	public void insertCustomerRecord(Customer aCustomer) {
//		Session session = entityManager.unwrap(Session.class);
		
		try {			
			//  session
			session = factory.getCurrentSession();
			// start a transaction
			session.beginTransaction();

			// save the customer object
			session.save(aCustomer);
			System.out.println("Customer Record : "+aCustomer+" creation completed.");
			
			// commit transaction
			session.getTransaction().commit();
		}  catch (Exception e){
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		}	
		
	}
	

	/**
	 * Updates a Customer record
	 * @param aCustomer - customer record with new customer details to be updated
	 * @param id - id of the customer to be updated
	 */
	@Override
	@Transactional
	public void updateAndSaveCustomerRecord(Customer aCustomer, int id ) {
//		Session session = entityManager.unwrap(Session.class);
		if (id!=0) {					
			try {
				//  session
				session = factory.getCurrentSession();
				
				// start a transaction
				session.beginTransaction();
			
				System.out.println("Customer ID to update is"+ id);
				Customer temp = session.get(Customer.class, id);
				
				if (temp!=null) {
					temp.setFirstName(aCustomer.getFirstName());
					temp.setLastName(aCustomer.getLastName());
					temp.setEmail(aCustomer.getEmail());
					
					System.out.println(	"Updated customer details ::::"+temp);
				
					//session.saveOrUpdate(temp);
					session.update(temp);
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Update Customer Record "+ temp.getFirstName()+" Done!");
					
				} else {
					System.err.println("The Customer "+id+" is not available in the database. Please provide customer ID that is in the DB.");
					session.getTransaction().rollback();
				}		
			} catch (Exception e) {
				System.out.println(e.getMessage());
				session.getTransaction().rollback();
			}
		} else {
			insertCustomerRecord(aCustomer);
		}
	}

	/**
	 * Deletes a Students record
	 * @param id : id of the customer record to be deleted
	 */
	@Override
	@Transactional
	public void deleteCustomerRecord(int id) {
//		Session session = entityManager.unwrap(Session.class);
		try {
			//  session
			session = factory.getCurrentSession();
			// start a transaction
			session.beginTransaction();

			// fetching record with a customer id 
			Customer deleteRec = session.get(Customer.class, id);
			if (deleteRec!=null) {
				// deleting value using session.delete method
				System.out.println("Deleting customer record : "+deleteRec.getFirstName());
				session.delete(deleteRec);				

				// commit transaction
				session.getTransaction().commit();

				System.out.println("Delete customer record of"+deleteRec+"Completed!");
				
			} else {
				System.err.println("The customer "+id+" is not available in the database. Please provide customer ID that is in the DB.");
				session.getTransaction().rollback();				
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
			session.getTransaction().rollback();	
		}	
	}	

	/**
	 * Reads all customer records in the database.
	 * @return Returns list of customer records
	 */
	
	@Override
	@Transactional
	
	public List<Customer> getAllCustomerRecords() {			
//		Session session = entityManager.unwrap(Session.class);
		List<Customer> customers = null;
		try {
			//  session
			session = factory.getCurrentSession();
			// start a transaction
			session.beginTransaction();

			// query Customer table
			customers = session.createQuery("from Customer", Customer.class).list();

			//display(customers);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Fetch All Customer records completed!");
		}  catch (Exception e){
			System.out.println(e.getMessage());
			session.getTransaction().rollback();	
		}	
		return customers;
	}
	
	
	@Override
	@Transactional
	public Optional<Customer> findByID(int aID) {
//		Session session = entityManager.unwrap(Session.class);		
		try {
			//  session
			session = factory.getCurrentSession();
			// start a transaction
			session.beginTransaction();

			System.out.println("Customer ID to find is"+ aID);
			Customer tempCust = session.get(Customer.class, aID);
			
			if (tempCust!=null) {

				//commit transaction
				session.getTransaction().commit();
				System.out.println("Customer Record is"+ tempCust.getFirstName()+".");
				
			} else {
				System.err.println("The customer "+aID+" is not available in the database. Please provide customer ID that is in the DB.");
				session.getTransaction().rollback();
			}		
			return Optional.ofNullable(tempCust);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		}
		return Optional.empty();
	}



	
	
	/*
	private void display(List<Student> aCustomers) {
		for (Customer customer : aCustomers) {
			System.out.print(customer+ "");
		}
	}
	*/
}
