package com.training.ordermatching.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "symbol_order")
public class SymbolOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "symbol_order_id")
    private long symbolOrderId;

    @Column(name = "symbol_id", nullable = false)
    private long symbolId;

    @Column(name = "order_id", nullable = false)
    private long orderId;

}
