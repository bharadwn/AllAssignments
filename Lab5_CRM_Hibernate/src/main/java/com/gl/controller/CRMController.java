package com.gl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.dao.CustomerRepository;
import com.gl.model.Customer;


@Controller
public class CRMController {

	@Autowired
	private CustomerRepository customerService;

	/**
	 * @param customerService DI and Ioc
	 */
	public CRMController(CustomerRepository customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/list")
	public String getCustomerList(Model theModel) {
		List<Customer> customers = this.customerService.getAllCustomerRecords();
		theModel.addAttribute("customers", customers);
		return "customer-list";
	}

	@GetMapping("/")
	public String showPage(Model theModel) {
		List<Customer> customers = this.customerService.getAllCustomerRecords();
		theModel.addAttribute("customers", customers);		
		return "customer-list";
	}

	@GetMapping("/updateForm/{id}")
	public String updateCustomerById(@PathVariable int id, Model theModel) throws Exception {
		System.out.println("id is:" + id);
		Optional<Customer> aCustomer = customerService.findByID(id);
		if (aCustomer.isPresent()) {
			// add customer object to the model
			theModel.addAttribute("customer", aCustomer.get());
			theModel.addAttribute("id", aCustomer.get().getId());
		} else {
			throw new Exception("Something went wrong, cannot find the customer record.");
		}
		return "update-form";
	}

	/*
	 * I tried PutMapping and Deletemapping, somehow its not working
	 */
	@GetMapping("/updateForm/processUpdateForm")
	public String processUpdateForm(@RequestParam("id") int theId,
			@ModelAttribute("customer") Customer newCustomerdeets)
	{
		// log the input data
		// System.out.println("custid is"+theId);
		customerService.updateAndSaveCustomerRecord(newCustomerdeets, theId);
		return "redirect:/list";
	}

	@RequestMapping("/showForm")
	public String showForm(Model theModel, @ModelAttribute("customer") Customer aCustomer) {
		// create a customer object
		Customer customer = new Customer();

		// add customer object to the model
		theModel.addAttribute("customer", customer);

		return "add-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("customer") Customer theCustomer) throws Exception {
		// log the input data
		System.out.println(
				theCustomer.getId() + "the Customer is: " + theCustomer.getFirstName() + " theCustomer.getLastName()  "
						+ theCustomer.getLastName() + " theCustomer.getEmail() " + theCustomer.getEmail());

		customerService.insertCustomerRecord(theCustomer);

		return "redirect:/list";
	}
	


	//Somehow I tried many ways of @DeleteMapping but its not working for me
	// Below method works fine.
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("custid") int theId) {
		this.customerService.deleteCustomerRecord(theId);
		return "redirect:/list";
	}

}
