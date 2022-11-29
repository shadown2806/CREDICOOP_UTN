package com.credicoop.utn.dto;


import lombok.Data;

import java.time.LocalDate;


@Data
public class ShopDTO {

    private Long id;
    private String companyName;
    private String phone;
    private String address;
    private LocalDate createdAt;

}
