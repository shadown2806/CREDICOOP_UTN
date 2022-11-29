package com.credicoop.utn.dto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class CustomizeAreaDTO {

    private Long id;
    private String area;
    private LocalDate createdAt;

}
