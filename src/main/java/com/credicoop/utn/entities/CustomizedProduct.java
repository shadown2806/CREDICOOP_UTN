package com.credicoop.utn.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customized_product")
public class CustomizedProduct {
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


    @OneToMany(mappedBy = "customizedProduct")
    private List<ProductBase> productBaseList;


    @ManyToMany
    private List<Shop> shopList;

    public CustomizedProduct(){

        this.shopList = new ArrayList<>();

    }




}