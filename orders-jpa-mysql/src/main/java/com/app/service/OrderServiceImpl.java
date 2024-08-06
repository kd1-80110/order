package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerDao;
import com.app.dao.DeliveryPartnerDao;
import com.app.dao.HotelDao;
import com.app.dao.OrderDao;
import com.app.dto.OrderDetailsDto;
import com.app.dto.OrderDto;
import com.app.entity.Customer;
import com.app.entity.DeliveryPartner;
import com.app.entity.Hotel;
import com.app.entity.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
    private OrderDao orderDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private DeliveryPartnerDao deliveryPartnerDao;

    @Override
    public List<OrderDetailsDto> getOrderDetails() {
        return orderDao.findOrderDetails();
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderDao.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(String orderId) {
        return convertToDto(orderDao.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found")));
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);

        Customer customer = customerDao.findById(orderDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setCustomer(customer);

        Hotel hotel = hotelDao.findById(orderDto.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        order.setHotel(hotel);

        DeliveryPartner deliveryPartner = deliveryPartnerDao.findById(orderDto.getPartnerId())
                .orElseThrow(() -> new RuntimeException("Delivery Partner not found"));
        order.setDeliveryPartner(deliveryPartner);

        return convertToDto(orderDao.save(order));
    }

    @Override
    public OrderDto updateOrder(String orderId, OrderDto orderDto) {
        Order order = orderDao.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        BeanUtils.copyProperties(orderDto, order);

        Customer customer = customerDao.findById(orderDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setCustomer(customer);

        Hotel hotel = hotelDao.findById(orderDto.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        order.setHotel(hotel);

        DeliveryPartner deliveryPartner = deliveryPartnerDao.findById(orderDto.getPartnerId())
                .orElseThrow(() -> new RuntimeException("Delivery Partner not found"));
        order.setDeliveryPartner(deliveryPartner);

        return convertToDto(orderDao.save(order));
    }

    @Override
    public void deleteOrder(String orderId) {
        orderDao.deleteById(orderId);
    }

    private OrderDto convertToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(order, orderDto);
        orderDto.setCustomerId(order.getCustomer().getCustomerId());
        orderDto.setHotelId(order.getHotel().getHotelId());
        orderDto.setPartnerId(order.getDeliveryPartner().getPartnerId());
        return orderDto;
    }

}
