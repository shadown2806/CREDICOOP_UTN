package com.credicoop.utn.dto;

import java.math.BigDecimal;
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
public class CustomizeDTO {

    private Long id;
    private String customizeType;
    private BigDecimal customizePrice;
    private String image;
    private String phrase;

}
