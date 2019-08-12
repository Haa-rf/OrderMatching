package com.training.ordermatching.service;

import com.training.ordermatching.model.SymbolOrder;

import java.util.List;

public interface SymbolOrderService {
    List<SymbolOrder> findBySymbolId(long symbolId);
}
