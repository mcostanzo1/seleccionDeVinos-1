package com.dp3.dao;

import com.dp3.domain.Order;
import com.dp3.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByStatusOrderByDeliveryDateDesc(OrderStatus status);
}