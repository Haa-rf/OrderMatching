package com.training.ordermatching.controller;

import com.training.ordermatching.model.Order;
import com.training.ordermatching.model.User;
import com.training.ordermatching.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;

@CrossOrigin
@RestController
@RequestMapping("/orderMatching/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/submit")
    public void submitOrder(@RequestBody Order param){
        log.info("order："+param.getTraderName()+","+param.getPrice());

        JSONObject response = new JSONObject();
        Order order = new Order();
        order.setTraderName(param.getTraderName());
        order.setOrderType(param.getOrderType());
        order.setSide(param.getSide());
        order.setQuantity(param.getQuantity());
        order.setPrice(param.getPrice());
        order.setStatus("pending");
        order.setCreateDate(new Timestamp(System.currentTimeMillis()));
        order.setLimitTime(param.getLimitTime());

        orderService.save(order);
    }
}
