package com.generation.simplisoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "roles") // Se usa para comunicarnos con la tabla que queremos, en este caso "Roles"

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Role {

    /* ------- Esto para indicarle a la tabla que ID es autoincrementable ------ */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* ----------------------------------------------------------------------------- */
    /*----- El atributo ID debe venir justo después de las sentencias de arriba ---- */
    /* ---------- Los atributos coinciden con las columnas de la tabla ------------- */
    /* ----------------------------------------------------------------------------- */
    @Column(name = "id_role")
    private Integer idRole;
    @Column(name = "role_name")
    private String roleName;
    
}
