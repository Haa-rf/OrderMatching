package com.training.ordermatching.controller;

import com.training.ordermatching.model.User;
import com.training.ordermatching.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/orderMatching/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String login(@RequestParam(value = "user_name") String username, @RequestParam(value = "password") String password) {
        User user = userService.findByUserNameAndPassword(username, password);
        JSONObject response = new JSONObject();
        if (user != null) {
            response.put("type", user.getType());
            response.put("status", true);
            response.put("Message", "success");
        } else {
            response.put("status", false);
            response.put("Message", "Invalid username or password");
        }

        return response.toString();
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody User param) {
        log.info("register--------name："+param.getUserName()+"，password:"+param.getPassword());

        JSONObject response = new JSONObject();
        if (userService.findByUserName(param.getUserName()) == null) {
            User user = new User();
            user.setUserName(param.getUserName());
            user.setPassword(param.getPassword());
            user.setType("trader");
            userService.save(user);
            response.put("status", true);
            response.put("Message", "success");
        } else {
            response.put("status", false);
            response.put("Message", "username existed");
        }

        return response.toString();
    }
}
