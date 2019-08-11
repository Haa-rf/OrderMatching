package com.training.ordermatching.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "trader_order")
public class Trader_Order {
    @Column(name = "user_id")
    private long userId;

    @Column(name = "trader_id")
    private long traderId;
}
