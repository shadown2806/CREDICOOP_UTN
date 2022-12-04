package com.credicoop.utn.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product_base")
public class ProductBase {

    @Id
    @Column(name = "product_code")
    private Long productCode;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;


    @ManyToOne(targetEntity = CustomizeArea.class)
    @JoinColumn(name = "customize_area_id",referencedColumnName = "id")
    private CustomizeArea customizeArea;

    @ManyToOne(targetEntity = Manager.class)
    @JoinColumn(name = "manager_id",referencedColumnName = "id")
    private Manager manager;

    public ProductBase() {

    }
}
