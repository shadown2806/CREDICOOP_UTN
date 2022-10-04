package com.credicoop.utn.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomizeDTO {

    private int id;
    private String customizeType;
    private BigDecimal customizePrice;
    private String image;
    private String phrase;

}
