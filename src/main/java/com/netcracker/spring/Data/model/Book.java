package com.netcracker.spring.Data.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name="name", nullable = false)
    private String name;

    @Column (name="price", nullable = false)
    private Integer price;

    @Column (name="storage", nullable = false)
    private String storage;

    @Column (name="count", nullable = false)
    private Integer count;
}
