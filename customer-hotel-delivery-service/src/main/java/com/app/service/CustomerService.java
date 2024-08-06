package com.app.service;

import java.util.List;

import com.app.dto.CustomerDto;

public interface CustomerService {

	List<CustomerDto> getAllCustomers();

	CustomerDto getCustomerById(String customerId);

	CustomerDto createCustomer(CustomerDto customerDto);

	CustomerDto updateCustomer(String customerId, CustomerDto customerDto);

	void deleteCustomer(String customerId);

}
