package com.credicoop.utn.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDTO {

    private Long orderNumber;
    private Date orderDate;
    private Date shipDate;
    private Boolean status;
    private BigDecimal orderAmount;

}
