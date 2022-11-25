package com.credicoop.utn.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class OrderDTO {

    private Long orderNumber;
    private LocalDate orderDate;
    private LocalDate shipDate;
    private Boolean status;
    private BigDecimal orderAmount;

}
