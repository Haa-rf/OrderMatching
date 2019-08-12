package com.training.ordermatching.service.impl;

import com.training.ordermatching.model.Symbol;
import com.training.ordermatching.repository.SymbolRepository;
import com.training.ordermatching.service.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymbolServiceImpl implements SymbolService {

    @Autowired
    private SymbolRepository symbolRepository;

    @Override
    public List<Symbol> findAll() {
        return symbolRepository.findAll();
    }
}
