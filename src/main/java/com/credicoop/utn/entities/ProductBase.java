package com.credicoop.utn.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product_base")
public class ProductBase {

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

    @ManyToOne(targetEntity = CustomizedProduct.class)
    @JoinColumn(name = "customize_product_id",referencedColumnName = "id")
    private CustomizedProduct customizedProduct;

    @ManyToOne(targetEntity = CustomizeArea.class)
    @JoinColumn(name = "customize_area_id",referencedColumnName = "id")
    private CustomizeArea customizeArea;

    @ManyToOne(targetEntity = Manager.class)
    @JoinColumn(name = "manager_id",referencedColumnName = "id")
    private Manager manager;

    public ProductBase() {

    }
}
