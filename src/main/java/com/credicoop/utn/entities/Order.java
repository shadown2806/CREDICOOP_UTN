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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_number")
    private Long orderNumber;
    @Column(name = "order_date", columnDefinition = "DATE")
    private LocalDate orderDate;
    @Column(name = "ship_date", columnDefinition = "DATE")
    private LocalDate shipDate;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "order_amount")
    private BigDecimal orderAmount;



    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Order order;

    @ManyToMany
    private List<CustomizedProduct> customizedProducts;

    public Order(){

        customizedProducts = new ArrayList<>();

    }

}
