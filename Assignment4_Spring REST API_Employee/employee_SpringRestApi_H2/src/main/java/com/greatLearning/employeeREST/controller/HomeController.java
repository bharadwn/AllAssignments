package com.greatLearning.employeeREST.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class HomeController {

	@ApiIgnore
	@GetMapping("")
	public RedirectView redirectWithUsingRedirectView(RedirectAttributes attributes) {
		// attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
		// attributes.addAttribute("attribute", "redirectWithRedirectView");
		return new RedirectView("/api");
	}

	/*
	 * @GetMapping("") public List<Employee> listAll() {
	 * 
	 * List<Employee> employees = employeeMSService.findAll(); return employees; }
	 */
}
