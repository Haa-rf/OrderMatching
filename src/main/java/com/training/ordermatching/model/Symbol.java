package com.training.ordermatching.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "symbol")
public class Symbol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "symbol_id")
    private long symbolId;

    @Column(name = "symbol_name", nullable = false, length = 128)
    private String symbolName;
}
