package com.generation.simplisoft.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderRegistroDTO {

    private String commentInitial;     // Comentario inicial al ingresar un equipo a Servicio Técnico   
    private String commentTechnical;   // Informe Técnico  
    private String commentClient;      // Informe para el cliente
    private String files;               // Archivos pdf, fotos, imagen, etc
    private String statusOrder;        // Reparado, en reparación, ingresado, sin revisar....
    private LocalDateTime orderCreationDate;
    private LocalDateTime orderCloseDate; 
    private Integer fkIdDevice;       // Indica a que dispositivo es la orden
    private Integer fkIdTicket;       // Indica el ticket asignado   

}
