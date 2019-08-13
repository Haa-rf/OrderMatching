package com.training.ordermatching.service.impl;

import com.training.ordermatching.model.Order;
import com.training.ordermatching.repository.OrderRepository;
import com.training.ordermatching.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Order findBySymbolAndSideIsBuy(String symbol) {
        return orderRepository.findBySymbolAndSideIsBuy(symbol);
    }

    @Override
    public Order findBySymbolAndSideIsSell(String symbol) {
        return orderRepository.findBySymbolAndSideIsSell(symbol);
    }

    @Override
    public Order findPendingBuyOrder(String symbol) {
        return orderRepository.findPendingBuyOrder(symbol);
    }

    @Override
    public Order findPendingSellOrder(String symbol) {
        return orderRepository.findPendingSellOrder(symbol);
    }

    @Override
    public List<Order> findPendingBuyOrderLimit10(String symbol) {
        return orderRepository.findPendingBuyOrderLimit10(symbol);
    }

    @Override
    public List<Order> findPendingSellOrderLimit10(String symbol) {
        return orderRepository.findPendingSellOrderLimit10(symbol);
    }


    @Override
    public Page<Order> findOrdersByTraderName(String trader_name, Pageable pageable) {
        return orderRepository.findOrdersByTraderName(trader_name,pageable);
    }

}
