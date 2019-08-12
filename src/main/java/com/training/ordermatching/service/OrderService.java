package com.training.ordermatching.service;

import com.training.ordermatching.model.Order;

import java.util.List;

public interface OrderService {
    Order findByOrderId(long orderId);
    void save(Order order);
    List<Order> findAllBySymbol(String symbol);
}
