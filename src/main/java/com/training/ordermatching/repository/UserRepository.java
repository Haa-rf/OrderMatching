package com.training.ordermatching.repository;

import com.training.ordermatching.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserNameAndPassword(String username, String password);

    User findByUserName(String username);
}
