package com.app.dto;

import lombok.Data;

@Data
public class CustomerDto {

	private String customerId;
	private String customerName;
	private String address;
	private Long phoneNo;
	private String emailId;

}
