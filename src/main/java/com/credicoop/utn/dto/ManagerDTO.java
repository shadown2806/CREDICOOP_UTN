package com.credicoop.utn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ManagerDTO {

    private Float id;
    private String username;
    private String password;
    private String email;
    private LocalDate createdAt;

}
