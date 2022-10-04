package com.credicoop.utn.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShoppingCartDTO {

    private Long id;
    private BigDecimal cartPriceAmount;
    private int quantity;
    private Boolean empty;

}
