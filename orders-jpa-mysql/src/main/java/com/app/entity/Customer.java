package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class Customer {
	@Id
	@Column(name = "customer_id", length = 10)
	private String customerId;

	@Column(name = "customer_name", length = 20)
	private String customerName;

	@Column(name = "address", length = 20)
	private String address;

	@Column(name = "phone_no")
	private Long phoneNo;

	@Column(name = "email_id", length = 20)
	private String emailId;
}
