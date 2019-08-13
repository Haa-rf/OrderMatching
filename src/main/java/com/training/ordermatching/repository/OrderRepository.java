package com.training.ordermatching.repository;

import com.training.ordermatching.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderId(long orderId);

    List<Order> findBySymbol(String symbol);

    @Query(value = "select * from orders where symbol=?1 and side='BUY' order by price DESC LIMIT 1", nativeQuery = true)
    Order findBySymbolAndSideIsBuy(String symbol);

    @Query(value = "select * from orders where symbol=?1 and side='SELL' order by price asc LIMIT 1", nativeQuery = true)
    Order findBySymbolAndSideIsSell(String symbol);

    @Query(value = "select * from orders where symbol=?1 and side='BUY' and status='pending' order by price desc LIMIT 1", nativeQuery = true)
    Order findPendingBuyOrder(String symbol);

    @Query(value = "select * from orders where symbol=?1 and side='SELL' and status='pending' order by price asc LIMIT 1", nativeQuery = true)
    Order findPendingSellOrder(String symbol);

    @Query(value = "select * from orders where status='pending'", nativeQuery = true)
    Page<Order> findPendingOrders(Pageable pageable);

    @Query(value = "select * from orders where trader_name=?1",nativeQuery = true)
    Page<Order> findOrdersByTraderName(String trader_name,Pageable pageable);

}
