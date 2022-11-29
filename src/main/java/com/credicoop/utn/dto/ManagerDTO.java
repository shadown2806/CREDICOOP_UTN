package com.credicoop.utn.dto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class ManagerDTO {

    private Float id;
    private String username;
    private String password;
    private String email;
    private LocalDate createdAt;

}
