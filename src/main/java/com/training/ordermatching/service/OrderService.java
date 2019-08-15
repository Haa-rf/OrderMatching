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

    List<Order> findPendingBuyOrderLimit20();

    List<Order> findPendingSellOrderLimit20();

    List<Order> findPendingBuyOrderLimit20(String symbol);

    List<Order> findPendingSellOrderLimit20(String symbol);

    Page<Order> findOrdersByTraderName(String trader_name, Pageable pageable);

    List<Order> findMatchOrderBySymbol(String symbol);
}
