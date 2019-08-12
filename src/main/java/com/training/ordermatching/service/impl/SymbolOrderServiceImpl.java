package com.training.ordermatching.service.impl;

import com.training.ordermatching.model.SymbolOrder;
import com.training.ordermatching.repository.SymbolOrderRepository;
import com.training.ordermatching.service.SymbolOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymbolOrderServiceImpl implements SymbolOrderService {

    @Autowired
    private SymbolOrderRepository symbolOrderRepository;

    @Override
    public List<SymbolOrder> findBySymbolId(long symbolId) {
        return symbolOrderRepository.findBySymbolId(symbolId);
    }
}
