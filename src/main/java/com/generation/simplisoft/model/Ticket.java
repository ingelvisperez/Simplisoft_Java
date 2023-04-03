package com.generation.simplisoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Tickets") // Se usa para comunicarnos con la tabla que queremos, en este caso "Roles"

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Ticket {
        
    /* ------- Esto para indicarle a la tabla que ID es autoincrementable ------ */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        /* ----------------------------------------------------------------------------- */
        /*----- El atributo ID debe venir justo después de las sentencias de arriba ---- */
        /* ---------- Los atributos coinciden con las columnas de la tabla ------------- */
        /* ----------------------------------------------------------------------------- */
        @Column(name = "id_ticket")
        private Integer idTicket;
        
        @CreationTimestamp          //establece automáticamente en la fecha y hora en que se inserta la entidad en la base de datos
        @Column(name = "ticket_creation_date")
        private LocalDateTime ticketCreationDate;        
        
        @UpdateTimestamp            //permite registrar automáticamente la fecha y hora de la última actualización
        @Column(name = "ticket_close_date")
        private LocalDateTime ticketCloseDate;
        
        @Column(name = "ticket_status")
        private String ticketStatus;           //Abierto, cerrado, en proceso.....
        
        @Column(name = "fk_id_ticketuser") 
        private Integer fkIdTicketuser;
}
