package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomerDto;
import com.app.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<CustomerDto> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/{id}")
	public CustomerDto getCustomerById(@PathVariable("id") String customerId) {
		return customerService.getCustomerById(customerId);
	}

	@PostMapping
	public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.createCustomer(customerDto);
	}

	@PutMapping("/{id}")
	public CustomerDto updateCustomer(@PathVariable("id") String customerId, @RequestBody CustomerDto customerDto) {
		return customerService.updateCustomer(customerId, customerDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("id") String customerId) {
		customerService.deleteCustomer(customerId);
		return ResponseEntity.noContent().build();
	}

}
