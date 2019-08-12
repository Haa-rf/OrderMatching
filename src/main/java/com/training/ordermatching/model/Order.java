package com.training.ordermatching.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "order_type", nullable = false, length = 128)
    private String orderType;

    @Column(name = "side", nullable = false, length = 128)
    private String side;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price")
    private float price;

    @Column(name = "status", length = 128)
    private String status;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "limit_time")
    private Date limitTime;

    @Column(name = "finish_date")
    private Date finishDate;
}
