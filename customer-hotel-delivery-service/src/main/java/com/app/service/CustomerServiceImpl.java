package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerDao;
import com.app.dto.CustomerDto;
import com.app.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<CustomerDto> getAllCustomers() {
		return customerDao.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public CustomerDto getCustomerById(String customerId) {
		return convertToDto(
				customerDao.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found")));
	}

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		return convertToDto(customerDao.save(customer));
	}

	@Override
	public CustomerDto updateCustomer(String customerId, CustomerDto customerDto) {
		Customer customer = customerDao.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found"));
		BeanUtils.copyProperties(customerDto, customer);
		return convertToDto(customerDao.save(customer));
	}

	@Override
	public void deleteCustomer(String customerId) {
		customerDao.deleteById(customerId);

	}

	private CustomerDto convertToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		BeanUtils.copyProperties(customer, customerDto);
		return customerDto;
	}

}
