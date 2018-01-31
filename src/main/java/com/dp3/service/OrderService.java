package com.dp3.service;

import com.dp3.dao.OrderRepository;
import com.dp3.domain.Order;
import com.dp3.domain.OrderDetail;
import com.dp3.domain.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private ProductService productService;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Transactional
    public Order generateNewOrder(Order order) {
        for (OrderDetail detail : order.getDetails()) {
            productService.discountStock(detail);
        }
        order.setStatus(OrderStatus.CREATED);
        return orderRepository.save(order);
    }

    @Transactional
    public Order progressOrder(Integer orderId) {
        Order order = orderRepository.findOne(orderId);
        if (order!=null) {
            order.setStatus(OrderStatus.IN_PROGRESS);
        }
        return orderRepository.save(order);
    }

    @Transactional
    public Order cancelOrder(Integer orderId) {
        Order order = orderRepository.findOne(orderId);
        for (OrderDetail detail : order.getDetails()) {
            productService.returnStock(detail);
        }
        order.setStatus(OrderStatus.CANCELED);
        return orderRepository.save(order);
    }

    @Transactional
    public Order finalizeOrder(Order order) {
        order.setStatus(OrderStatus.FINISHED);
        return orderRepository.save(order);
    }

    public Order findOne(Integer id) {
        return orderRepository.findOne(id);
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatusOrderByDeliveryDate(status);
    }

}
