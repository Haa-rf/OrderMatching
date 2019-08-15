package com.training.ordermatching.controller;

import com.training.ordermatching.model.Order;
import com.training.ordermatching.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SymbolControllerTest {

    @MockBean
    OrderService orderService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllSymbol() throws Exception {
        Order param = new Order();
        param.setTraderName("test2");
        param.setOrderType("MKT");
        param.setSymbol("APPLE");
        param.setSide("BUY");
        param.setQuantity(100);
        param.setQuantityLeft(100);
        param.setPrice((float) 199);
        Mockito.when(orderService.findBySymbolAndSideIsBuy((Mockito.anyString()))).thenReturn(param);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/orderMatching/symbol/price")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String message = mvcResult.getResponse().getContentAsString();
        assertNotNull(message);
    }
}