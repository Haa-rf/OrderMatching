package com.training.ordermatching.service.impl;

import com.training.ordermatching.model.Order;
import com.training.ordermatching.repository.OrderRepository;
import com.training.ordermatching.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order findByOrderId(long orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> findBySymbol(String symbol) {
        return orderRepository.findBySymbol(symbol);
    }
}
