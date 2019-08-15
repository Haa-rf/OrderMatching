package com.training.ordermatching.controller;

import com.alibaba.fastjson.JSON;
import com.training.ordermatching.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void login() throws Exception {
        //success
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/orderMatching/user/login")
                .accept(MediaType.APPLICATION_JSON)
                .param("user_name", "test_trader")
                .param("password", "123456"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String message = mvcResult.getResponse().getContentAsString();
        assertNotNull(message);

        //failed
        MvcResult mvcResult1 = mockMvc.perform(MockMvcRequestBuilders.get("/orderMatching/user/login")
                .accept(MediaType.APPLICATION_JSON)
                .param("user_name", "test_trader")
                .param("password", "1234567"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String message1 = mvcResult1.getResponse().getContentAsString();
        assertNotNull(message1);
    }

    @Test
    public void register() throws Exception {

        //success
        User param = new User();
        param.setUserName("testRegister1");
        param.setPassword("123456");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/orderMatching/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(param)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String message = mvcResult.getResponse().getContentAsString();
        assertNotNull(message);

        //failed
        param.setUserName("testRegister1");
        param.setPassword("123456");
        MvcResult mvcResult1 = mockMvc.perform(MockMvcRequestBuilders.post("/orderMatching/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(param)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String message1 = mvcResult1.getResponse().getContentAsString();
        assertNotNull(message1);
    }
}

