package com.training.ordermatching.component;

import com.training.ordermatching.model.Order;
import com.training.ordermatching.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class MatchingComponent {

    @Autowired
    private OrderService orderService;
    @Autowired
    private WebSocketServer webSocketServer;;

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
        order.setPrice(fundOrder.getPrice());

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

        List<Order> orders = new ArrayList<>();

        if (order.getQuantityLeft()==0){
            order.setStatus("matched");
            orders.add(order);
        }

        if (fundOrder.getQuantityLeft()==0){
            fundOrder.setStatus("matched");
            orders.add(fundOrder);
        }

        orderService.save(order);
        orderService.save(fundOrder);
        orders.addAll(orderService.findPendingBuyOrderLimit10());
        orders.addAll(orderService.findPendingSellOrderLimit10());
        JSONArray response = new JSONArray();
        for (Order o : orders) {
            JSONObject re = new JSONObject();
            re.put("symbol", o.getSymbol());
            re.put("side", o.getSide());
            re.put("quantity", o.getQuantity());
            re.put("price",o.getPrice());
            re.put("create_date", o.getCreateDate());
            response.put(re);
        }

        webSocketServer.groupSending(response.toString());
    }

}
