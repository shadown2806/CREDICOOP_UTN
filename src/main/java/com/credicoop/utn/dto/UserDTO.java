package com.credicoop.utn.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private LocalDate createdAt;
    private LocalDate modifiedAt;

}
