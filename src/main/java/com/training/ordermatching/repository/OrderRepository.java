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

    @Query(value = "SELECT * FROM orders a WHERE 20>(SELECT COUNT(*) FROM orders WHERE order_id=a.order_id and price>a.price)  and\n" +
            "side='BUY' and status='pending' ORDER BY a.symbol,a.price desc ", nativeQuery = true)
    List<Order> findPendingBuyOrderLimit20();

    @Query(value = "SELECT * FROM orders a WHERE 20>(SELECT COUNT(*) FROM orders WHERE order_id=a.order_id and price<a.price)  and\n" +
            "side='SELL' and status='pending' ORDER BY a.symbol,a.price ASC", nativeQuery = true)
    List<Order> findPendingSellOrderLimit20();

    @Query(value = "select * from orders where symbol=?1 and side='BUY' and status='pending' order by price desc LIMIT 20", nativeQuery = true)
    List<Order> findPendingBuyOrderLimit20(String symbol);

    @Query(value = "select * from orders where symbol=?1 and side='SELL' and status='pending' order by price asc LIMIT 20", nativeQuery = true)
    List<Order> findPendingSellOrderLimit20(String symbol);

    @Query(value = "select * from orders where trader_name=?1",nativeQuery = true)
    Page<Order> findOrdersByTraderName(String trader_name,Pageable pageable);

    @Query(value = "select * from orders where symbol=?1 and status = 'matched' and side='BUY' order by finish_date DESC lIMIT 50", nativeQuery = true)
    List<Order> findMatchOrderBySymbol(String symbol);

}
