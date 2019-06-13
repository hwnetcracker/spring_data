package com.netcracker.spring.Data.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name="date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "seller")
    private Shop seller;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;

    @Column (name="count", nullable = false)
    private Integer count;

    @Column (name="cost", nullable = false)
    private Integer cost;
}
