package com.credicoop.utn.entities;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Product")
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
    @Column(name = "stock", columnDefinition = "DATE")
    private Integer stock;
    @Column(name = "product_available")
    private Boolean productAvailable;
    @Column(name = "discount_available")
    private Boolean discountAvailable;
}