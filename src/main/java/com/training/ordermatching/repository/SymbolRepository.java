package com.training.ordermatching.repository;

import com.training.ordermatching.model.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymbolRepository extends JpaRepository<Symbol,Long> {
}
