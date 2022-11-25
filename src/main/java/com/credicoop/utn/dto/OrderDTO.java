package com.credicoop.utn.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {

    private Long orderNumber;
    private LocalDate orderDate;
    private LocalDate shipDate;
    private Boolean status;
    private BigDecimal orderAmount;

}
