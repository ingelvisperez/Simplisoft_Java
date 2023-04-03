package com.generation.simplisoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserRegistroDTO {

    private String rut;
    private String username;
    private String userPassword;
    private String email;
    private String address;
    private Boolean userStatus; // Usuario Activo(1) o Inactivo (0)
    private String phone;
    private Integer fkIdRole;
}
