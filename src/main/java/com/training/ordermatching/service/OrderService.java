package com.training.ordermatching.service;

import com.training.ordermatching.model.Order;

public interface OrderService {
    Order findByOrderId(long orderId);
    void save(Order order);
}
