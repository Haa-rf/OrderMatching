package com.training.ordermatching.repository;

import com.training.ordermatching.model.SymbolOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SymbolOrderRepository extends JpaRepository<SymbolOrder, Long> {

    List<SymbolOrder> findBySymbolId(long symbolId);
}
