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
public class ProductBaseDTO {

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
