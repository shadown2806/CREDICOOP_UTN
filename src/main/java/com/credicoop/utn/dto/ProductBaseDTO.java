package com.credicoop.utn.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.credicoop.utn.entities.Manager;
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

    private Long productCode;
    private String name;
    private BigDecimal price;
    private Long managerId;
    private Long customizeAreaId;

}
