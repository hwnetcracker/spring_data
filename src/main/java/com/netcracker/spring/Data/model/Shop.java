package com.netcracker.spring.Data.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="shops")
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name="name", nullable = false)
    private String name;

    @Column (name="district", nullable = false)
    private String district;

    @Column (name="commission", nullable = false)
    private Double commission;
}
