package com.app.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "order_id", length = 36)
	private String orderId;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "hotel_id", nullable = false)
	private Hotel hotel;

	@ManyToOne
	@JoinColumn(name = "partner_id", nullable = false)
	private DeliveryPartner deliveryPartner;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "order_amount")
	private Integer orderAmount;
}
