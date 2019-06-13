package com.netcracker.spring.Data.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name="last_name", nullable = false)
    private String lastName;

    @Column (name="district", nullable = false)
    private String district;

    @Column (name="sale", nullable = false)
    private Double sale;
}
