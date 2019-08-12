package com.training.ordermatching.repository;

import com.training.ordermatching.model.SymbolOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymbolOrderRepository extends JpaRepository<SymbolOrder, Long> {
}
