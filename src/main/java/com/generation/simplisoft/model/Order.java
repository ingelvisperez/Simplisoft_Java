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

@Entity(name = "Orders") // Se usa para comunicarnos con la tabla que queremos, en este caso "Orders"

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Order {
        /* ------- Esto para indicarle a la tabla que ID es autoincrementable ------ */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        /* ----------------------------------------------------------------------------- */
        /*----- El atributo ID debe venir justo después de las sentencias de arriba ---- */
        /* ---------- Los atributos coinciden con las columnas de la tabla ------------- */
        /* ----------------------------------------------------------------------------- */
        @Column(name = "id_order_service")
        private Integer idOrderService;
        
        @Column(name = "comment_initial")
        private String commentInitial;     // Comentario inicial al ingresar un equipo a Servicio Técnico
        
        @Column(name = "comment_technical")
        private String commentTechnical;   // Informe Técnico
        
        @Column(name = "comment_client")
        private String commentClient;      // Informe para el cliente
        
        // Preguntar files que es BLOB
        /* Pame recomienda String y que se coloque una url que
         * apunte al archivo que se quiera subir
         */
        private String files;               // Archivos pdf, fotos, imagen, etc
        
        @Column(name = "status_order")
        private String statusOrder;        // Reparado, en reparación, ingresado, sin revisar....
        
        @CreationTimestamp                  //establece automáticamente en la fecha y hora en que se inserta la entidad en la base de datos
        @Column(name = "order_creation_date")
        private LocalDateTime orderCreationDate;
        
        @UpdateTimestamp                    //permite registrar automáticamente la fecha y hora de la última actualización
        @Column(name = "order_close_date")
        private LocalDateTime orderCloseDate; 
        
        @Column(name = "fk_id_device")
        private Integer fkIdDevice;       // 
        
        @Column(name = "fk_id_ticket")
        private Integer fkIdTicket;       // 
        
       
       
       
}
