package com.training.ordermatching.controller;

import com.training.ordermatching.model.User;
import com.training.ordermatching.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderMatching/user")
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
    public String register(@RequestParam(value = "user_name") String username, @RequestParam(value = "password") String password) {
        JSONObject response = new JSONObject();
        if (userService.findByUserName(username) == null) {
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);
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
