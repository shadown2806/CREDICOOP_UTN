package com.credicoop.utn.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customize")
public class Customize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="customize_type")
    private String customizeType;
    @Column(name="customize_price")
    private BigDecimal customizePrice;
    @Column(name="image")
    private String image;
    @Column(name="phrase")
    private String phrase;


}
