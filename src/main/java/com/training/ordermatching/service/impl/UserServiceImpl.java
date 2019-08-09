package com.training.ordermatching.service.impl;

import com.training.ordermatching.model.User;
import com.training.ordermatching.repository.UserRepository;
import com.training.ordermatching.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserNameAndPassword(String username, String password) {
        return userRepository.findByUserNameAndPassword(username,password);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
