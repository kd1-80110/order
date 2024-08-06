package com.app.dto;

import lombok.Data;

@Data
public class OrderDetailsDto {

	private String orderId;
	private String customerName;
	private String hotelName;
	private String partnerName;
	private Integer orderAmount;

	public OrderDetailsDto(String orderId, String customerName, String hotelName, String partnerName,
			Integer orderAmount) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.hotelName = hotelName;
		this.partnerName = partnerName;
		this.orderAmount = orderAmount;
	}

}
