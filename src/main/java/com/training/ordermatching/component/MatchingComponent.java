package com.training.ordermatching.component;

import com.training.ordermatching.model.Order;
import com.training.ordermatching.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Slf4j
public class MatchingComponent {

    @Autowired
    private OrderService orderService;

    @Async(value = "orderTaskExecutor")
    public void asyncMatching(Order order) {

        if (order.getOrderType().equals("MKT")){
            doMKTMatching(order);
        }
        log.info(" -------------------do matching-------------");
    }

    private void doMKTMatching(Order order){
        if (order.getSide().equals("BUY")){
            Order sellPendingOrder = orderService.findPendingSellOrder(order.getSymbol());
            calMKT(order,sellPendingOrder);
        }else {
            Order buyPendingOrder = orderService.findPendingSellOrder(order.getSymbol());
            calMKT(order,buyPendingOrder);
        }
    }

    private void calMKT(Order order,Order fundOrder){
        if (order.getQuantityLeft()<fundOrder.getQuantityLeft()){
            fundOrder.setQuantityLeft(fundOrder.getQuantityLeft()-order.getQuantityLeft());
            order.setQuantityLeft(0);
            order.setFinishDate(new Timestamp(System.currentTimeMillis()));
        }else if (order.getQuantityLeft()>fundOrder.getQuantityLeft()){
            order.setQuantityLeft(order.getQuantityLeft() - fundOrder.getQuantityLeft());
            fundOrder.setQuantityLeft(0);
            fundOrder.setFinishDate(new Timestamp(System.currentTimeMillis()));
        }else {
            order.setQuantityLeft(0);
            order.setFinishDate(new Timestamp(System.currentTimeMillis()));
            fundOrder.setQuantityLeft(0);
            fundOrder.setFinishDate(new Timestamp(System.currentTimeMillis()));
        }

        if (order.getQuantityLeft()==0){
            order.setStatus("matched");
        }

        if (fundOrder.getQuantityLeft()==0){
            fundOrder.setStatus("matched");
        }

        orderService.save(order);
        orderService.save(fundOrder);
    }

}
