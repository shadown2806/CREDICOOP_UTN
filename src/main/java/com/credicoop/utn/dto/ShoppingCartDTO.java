package com.credicoop.utn.dto;

import java.math.BigDecimal;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
=======
import java.time.LocalDate;
>>>>>>> 0206828f616645c2566379fb6b5b51e2730782c7


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShoppingCartDTO {

    private Long id;
    private BigDecimal cartPriceAmount;
    private int quantity;
    private Boolean empty;
    private LocalDate createdAt;
}
