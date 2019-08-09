package com.training.ordermatching.service;

import com.training.ordermatching.model.User;

public interface UserService {
    User findByUserNameAndPassword(String username, String password);
    User findByUserName(String username);
    void save(User user);

}
