package com.dp3.service;

import com.dp3.dao.OrderRepository;
import com.dp3.domain.Order;
import com.dp3.domain.OrderDetail;
import com.dp3.domain.OrderStatus;
import com.dp3.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Map;

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
        /*
        order.setStatus(OrderStatus.CREATED);

        for (OrderDetail detail : order.getDetails()) {

            productService.discountStock(detail);
        }
        */
        return orderRepository.save(order);
    }
}
