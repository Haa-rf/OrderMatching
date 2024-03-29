package com.training.ordermatching.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "trader_name" , nullable = false, length = 128)
    private String traderName;

    @Column(name = "order_type", nullable = false, length = 128)
    private String orderType;

    @Column(name = "symbol", nullable = false, length = 128)
    private String symbol;

    @Column(name = "side", nullable = false, length = 128)
    private String side;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "quantity_left", nullable = false)
    private Integer quantityLeft;

    @Column(name = "price")
    private Float price;

    @Column(name = "status", length = 128)
    private String status;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "limit_time")
    private Integer limitTime;

    @Column(name = "finish_date")
    private Timestamp finishDate;
}
