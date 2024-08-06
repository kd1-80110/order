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

import com.app.dto.OrderDetailsDto;
import com.app.dto.OrderDto;
import com.app.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/details")
	public List<OrderDetailsDto> getOrderDetails() {
		return orderService.getOrderDetails();
	}

	@GetMapping
	public List<OrderDto> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/{id}")
	public OrderDto getOrderById(@PathVariable("id") String orderId) {
		return orderService.getOrderById(orderId);
	}

	@PostMapping
	public OrderDto createOrder(@RequestBody OrderDto orderDto) {
		return orderService.createOrder(orderDto);
	}

	@PutMapping("/{id}")
	public OrderDto updateOrder(@PathVariable("id") String orderId, @RequestBody OrderDto orderDto) {
		return orderService.updateOrder(orderId, orderDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable("id") String orderId) {
		orderService.deleteOrder(orderId);
		return ResponseEntity.noContent().build();
	}

}
