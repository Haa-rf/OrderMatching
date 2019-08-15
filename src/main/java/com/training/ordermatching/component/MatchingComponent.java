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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class MatchingComponent {

    @Autowired
    private OrderService orderService;
    @Autowired
    private WebSocketServer webSocketServer;
    @Autowired
    private OrderLog orderLog;

    @Async(value = "orderTaskExecutor")
    public void asyncMatching(Order order) {

        switch (order.getOrderType()) {
            case "MKT":
                doMKTMatching(order);
                break;
            case "LMT":
                doLMTMatching(order);
                break;
            default:
                log.info("------------asyncMatching : default-------------");
                break;
        }

        log.info(" -------------------do matching-------------");
    }

    private void doMKTMatching(Order order) {
        Order fundOrder;

        if (order.getSide().equals("BUY")) {
            fundOrder = orderService.findPendingSellOrder(order.getSymbol());
        } else {
            fundOrder = orderService.findPendingBuyOrder(order.getSymbol());
        }

        order.setPrice(fundOrder.getPrice());
        calMKTorLMT(order, fundOrder);
    }

    private void doLMTMatching(Order order) {
        Order fundOrder;

        if (order.getSide().equals("BUY")) {
            fundOrder = orderService.findPendingSellOrder(order.getSymbol());
        } else {
            fundOrder = orderService.findPendingBuyOrder(order.getSymbol());
        }
        log.info("-------fundOrder,price:" + fundOrder.getPrice() + ";--------order,price:" + order.getPrice());
        float fundOrderPrice = fundOrder.getPrice();
        float orderPrice = order.getPrice();
        if (fundOrderPrice == orderPrice) {
            calMKTorLMT(order, fundOrder);
        }else {
            List<Order> orders = new ArrayList<>();
            orders.addAll(orderService.findPendingBuyOrderLimit20());
            orders.addAll(orderService.findPendingSellOrderLimit20());
            JSONArray response = new JSONArray();
            for (Order o : orders) {
                JSONObject re = new JSONObject();
                re.put("symbol", o.getSymbol());
                re.put("side", o.getSide());
                re.put("quantity", o.getQuantityLeft());
                re.put("price", o.getPrice());
                re.put("create_date", o.getCreateDate());
                response.put(re);
            }

            webSocketServer.groupSending(response.toString());
        }
    }

    private void calMKTorLMT(Order order, Order fundOrder) {

        if (order.getQuantityLeft() < fundOrder.getQuantityLeft()) {
            fundOrder.setQuantityLeft(fundOrder.getQuantityLeft() - order.getQuantityLeft());
            order.setQuantityLeft(0);
            order.setFinishDate(new Timestamp(System.currentTimeMillis()));
        } else if (order.getQuantityLeft() > fundOrder.getQuantityLeft()) {
            order.setQuantityLeft(order.getQuantityLeft() - fundOrder.getQuantityLeft());
            fundOrder.setQuantityLeft(0);
            fundOrder.setFinishDate(new Timestamp(System.currentTimeMillis()));
        } else {
            log.info("--------------Quantity Left is same");
            order.setQuantityLeft(0);
            Timestamp finishDate = new Timestamp(System.currentTimeMillis());
            order.setFinishDate(finishDate);
            fundOrder.setQuantityLeft(0);
            fundOrder.setFinishDate(finishDate);
        }

        List<Order> orders = new ArrayList<>();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(date);
        String fileName = time+".log";

        orderLog.createFile(fileName);

        if (order.getQuantityLeft() == 0) {
            order.setStatus("matched");
            String message = "*********    The order is created at: "+date.toString()+",Order detail: "+order.toString()+System.getProperty("line.separator");
            orderLog.writeFileAppend(fileName,message);
            log.info("--------------order matched");
        }

        if (fundOrder.getQuantityLeft() == 0) {
            fundOrder.setStatus("matched");
            String message = "*********    The order is created at: "+date.toString()+",Order detail: "+fundOrder.toString()+System.getProperty("line.separator");
            orderLog.writeFileAppend(fileName,message);
            log.info("--------------fundOrder matched");
        }

        orderService.save(order);
        orderService.save(fundOrder);
        log.info("--------------order saved");
        log.info("--------------fundOrder："+fundOrder.toString());
        log.info("--------------order:"+order.toString());

        orders.addAll(orderService.findPendingBuyOrderLimit20());
        orders.addAll(orderService.findPendingSellOrderLimit20());
        JSONArray response = new JSONArray();
        for (Order o : orders) {
            JSONObject re = new JSONObject();
            re.put("symbol", o.getSymbol());
            re.put("side", o.getSide());
            re.put("quantity", o.getQuantityLeft());
            re.put("price", o.getPrice());
            re.put("create_date", o.getCreateDate());
            response.put(re);
        }

        webSocketServer.groupSending(response.toString());
    }

}
