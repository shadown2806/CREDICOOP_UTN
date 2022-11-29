package com.credicoop.utn.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CustomizeDTO {

    private int id;
    private String customizeType;
    private BigDecimal customizePrice;
    private String image;
    private String phrase;
    private LocalDate createdAt;
}
