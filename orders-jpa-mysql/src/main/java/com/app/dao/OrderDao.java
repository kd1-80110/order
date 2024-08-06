package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.OrderDetailsDto;
import com.app.entity.Order;

public interface OrderDao extends JpaRepository<Order, String> {

	@Query("SELECT new com.app.dto.OrderDetailsDto(o.orderId, c.customerName, h.hotelName, dp.partnerName, o.orderAmount) " +
            "FROM Order o " +
            "JOIN o.customer c " +
            "JOIN o.hotel h " +
            "JOIN o.deliveryPartner dp " +
            "ORDER BY o.orderId ASC")
    List<OrderDetailsDto> findOrderDetails();
}
