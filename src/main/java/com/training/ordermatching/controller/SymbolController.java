package com.training.ordermatching.controller;

import com.training.ordermatching.model.Order;
import com.training.ordermatching.model.Symbol;
import com.training.ordermatching.service.OrderService;
import com.training.ordermatching.service.SymbolService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orderMatching/symbol")
@Slf4j
public class SymbolController {

    @Autowired
    private SymbolService symbolService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/price")
    public String getAllSymbol(){
        List<Symbol> symbols = symbolService.findAll();
        JSONArray response = new JSONArray();
        for (Symbol symbol:symbols){
            JSONObject re = new JSONObject();
            log.info("----------------symbol name:"+symbol.getSymbolName());
            re.put("symbol",symbol.getSymbolName());

            Order buyOrder = orderService.findBySymbolAndSideIsBuy(symbol.getSymbolName());
            Order sellOrder = orderService.findBySymbolAndSideIsSell(symbol.getSymbolName());
            float bid = buyOrder==null?0:buyOrder.getPrice();
            float ask = sellOrder==null?0:sellOrder.getPrice();

            log.info("--------------order-----bid :"+bid+",ask:"+ask);
            re.put("bid",bid);
            re.put("ask",ask);
            response.put(re);
        }
        return  response.toString();
    }

}
