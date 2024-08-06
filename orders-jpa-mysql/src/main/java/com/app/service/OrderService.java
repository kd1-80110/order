package com.app.service;

import java.util.List;

import com.app.dto.OrderDetailsDto;
import com.app.dto.OrderDto;

public interface OrderService {

	List<OrderDto> getAllOrders();

	OrderDto getOrderById(String orderId);

	OrderDto createOrder(OrderDto orderDto);

	OrderDto updateOrder(String orderId, OrderDto orderDto);

	void deleteOrder(String orderId);

	List<OrderDetailsDto> getOrderDetails();

}
