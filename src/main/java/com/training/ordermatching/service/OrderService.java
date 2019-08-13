package com.training.ordermatching.service;

import com.training.ordermatching.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    Order findByOrderId(long orderId);

    void save(Order order);

    List<Order> findBySymbol(String symbol);

    Order findBySymbolAndSideIsBuy(String symbol);

    Order findBySymbolAndSideIsSell(String symbol);

    Order findPendingBuyOrder(String symbol);

    Order findPendingSellOrder(String symbol);

    Page<Order> findPendingOrders(Pageable pageable);

    Page<Order> findOrdersByTraderName(String trader_name,Pageable pageable);

}
