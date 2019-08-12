package com.training.ordermatching.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "trader_order")
public class TraderOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trader_order_id")
    private long traderOrderId;

    @Column(name = "user_id",nullable = false)
    private long userId;

    @Column(name = "trader_id",nullable = false)
    private long traderId;
}
