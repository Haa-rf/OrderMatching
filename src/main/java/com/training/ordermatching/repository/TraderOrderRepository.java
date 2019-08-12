package com.training.ordermatching.repository;

import com.training.ordermatching.model.TraderOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraderOrderRepository extends JpaRepository<TraderOrder,Long> {

}
