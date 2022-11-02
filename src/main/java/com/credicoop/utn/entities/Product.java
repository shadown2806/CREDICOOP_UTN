package com.credicoop.utn.entities;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "created_at", columnDefinition = "DATE")
    private LocalDate createdAt;
    @Column(name = "modified_at", columnDefinition = "DATE")
    private LocalDate modifiedAt;
    @Column(name = "deleted_at", columnDefinition = "DATE")
    private LocalDate deletedAt;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "product_available")
    private Boolean productAvailable;


    @OneToMany(mappedBy = "product")
    private List<CustomizeArea> customizeAreaList;

    @ManyToOne(targetEntity = Manager.class)
    @JoinColumn(name = "manager_id",referencedColumnName = "id")
    private Manager manager;

    @ManyToMany
    private List<Shop> shopList;

    public Product(){

        this.customizeAreaList = new ArrayList<>();
        this.shopList = new ArrayList<>();

    }




}