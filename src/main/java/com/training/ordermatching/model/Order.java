package com.training.ordermatching.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "symbol", nullable = false, length = 128)
    private String symbol;

    @Column(name = "order_type", nullable = false, length = 128)
    private String orderType;

    @Column(name = "side", nullable = false, length = 128)
    private String side;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)   //mark
    private float price;

    @Column(name = "status", nullable = false, length = 9)
    private String status;

    @Column(name = "create_date", nullable = false)
    private Data createDate;

    @Column(name = "finish_date", nullable = false)
    private Data finishDate;
}
