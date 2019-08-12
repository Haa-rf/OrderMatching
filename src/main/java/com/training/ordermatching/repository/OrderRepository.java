package com.training.ordermatching.repository;

import com.training.ordermatching.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByOrderId(long orderId);
    List<Order> findAllBySymbol(String symbol);
}
