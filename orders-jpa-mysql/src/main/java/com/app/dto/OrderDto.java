package com.app.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class OrderDto {

	private String orderId;
	private String customerId;
	private String hotelId;
	private String partnerId;
	private Date orderDate;
	private Integer orderAmount;

}
