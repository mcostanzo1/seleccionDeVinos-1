package com.dp3.service;

import com.dp3.dao.OrderRepository;
import com.dp3.domain.Order;
import com.dp3.domain.OrderDetail;
import com.dp3.domain.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private ProductService productService;

    @Transactional
    public Order generateNewOrder(Order order) {
        for (OrderDetail detail : order.getDetails()) {
            productService.discountStock(detail);
        }
        order.setStatus(OrderStatus.CREATED);
        return orderRepository.save(order);
    }

    @Transactional
    public Order cancelOrder(Order order) {
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



}
