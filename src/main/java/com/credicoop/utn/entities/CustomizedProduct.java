package com.credicoop.utn.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
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

    @Column(name = "customized_area_id")
    private Long customizedAreaId;

    @Column(name = "customized_id")
    private Long customizedId;

    @ManyToOne(targetEntity = ProductBase.class)
    @JoinColumn(name = "product_base_id",referencedColumnName = "product_code")
    private ProductBase productBaseId;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category categoryId;

    @ManyToMany
    private List<Shop> shopList;

    public CustomizedProduct(){

        this.shopList = new ArrayList<>();

    }
}