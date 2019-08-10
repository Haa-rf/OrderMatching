package com.training.ordermatching.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "user_name", nullable = false, length = 128)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "type", length = 128)
    private String type;
}
