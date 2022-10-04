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

}
