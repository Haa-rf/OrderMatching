package com.training.ordermatching.repository;

import com.training.ordermatching.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
