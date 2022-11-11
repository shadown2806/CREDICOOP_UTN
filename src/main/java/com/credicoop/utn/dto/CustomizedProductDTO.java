package com.credicoop.utn.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CustomizedProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
    private LocalDate deletedAt;
    private Integer stock;
    private Boolean productAvailable;
    private Boolean discountAvailable;

}