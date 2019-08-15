package com.training.ordermatching.controller;

import com.alibaba.fastjson.JSON;
import com.training.ordermatching.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void submitOrder() throws Exception {
        Order param = new Order();
        param.setTraderName("test2");
        param.setOrderType("MKT");
        param.setSymbol("APPLE");
        param.setSide("BUY");
        param.setQuantity(100);
        param.setQuantityLeft(100);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/orderMatching/order/submit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(param)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String message = mvcResult.getResponse().getContentAsString();
        assertNotNull(message);

        param.setOrderType("LMT");
        param.setPrice((float) 190.0);
        MvcResult mvcResult1 = mockMvc.perform(MockMvcRequestBuilders.post("/orderMatching/order/submit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(param)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String message1 = mvcResult1.getResponse().getContentAsString();
        assertNotNull(message1);

        param.setOrderType("MKT");
        param.setSide("SELL");
        MvcResult mvcResult2 = mockMvc.perform(MockMvcRequestBuilders.post("/orderMatching/order/submit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(param)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String message2 = mvcResult2.getResponse().getContentAsString();
        assertNotNull(message2);

        param.setOrderType("LMT");
        param.setPrice((float) 207.9);
        MvcResult mvcResult3 = mockMvc.perform(MockMvcRequestBuilders.post("/orderMatching/order/submit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(param)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String message3 = mvcResult3.getResponse().getContentAsString();
        assertNotNull(message3);


    }

    @Test
    public void getPendingOrders() throws Exception {
        List<String> param = new ArrayList<>();
        param.add("APPLE");
        param.add("IBM");
        param.add("CITI");
        param.add("BABA");
        param.add("BAIDU");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/orderMatching/order/pendingOrders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(param)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String message = mvcResult.getResponse().getContentAsString();
        assertNotNull(message);

    }

    @Test
    public void getHistoryOrder() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/orderMatching/order/historyOrder")
                .accept(MediaType.APPLICATION_JSON)
                .param("pageSize", "10")
                .param("pageIndex", "0")
                .param("user_name","test_trader1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String message = mvcResult.getResponse().getContentAsString();
        assertNotNull(message);
    }

    @Test
    public void getHistoryMatch() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/orderMatching/order/historyMatch")
                .accept(MediaType.APPLICATION_JSON)
                .param("symbol", "APPLE"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String message = mvcResult.getResponse().getContentAsString();
        assertNotNull(message);
    }
}