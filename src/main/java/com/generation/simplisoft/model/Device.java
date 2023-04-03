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

@Entity(name = "Devices") // Se usa para comunicarnos con la tabla que queremos, en este caso "Devices"

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Device {
        /* ------- Esto para indicarle a la tabla que ID es autoincrementable ------ */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        /* ----------------------------------------------------------------------------- */
        /*----- El atributo ID debe venir justo después de las sentencias de arriba ---- */
        /* ---------- Los atributos coinciden con las columnas de la tabla ------------- */
        /* ----------------------------------------------------------------------------- */
        @Column(name = "id_device")
        private Integer idDevice;
        
        @Column(name = "device_type")
        private String deviceType;     //tipo de dispositivo
        
        @Column(name = "device_brand")
        private String deviceBrand;    // marca del dispositivo
        
        @Column(name = "device_model")
        private String deviceModel;    // Modelo del dispositivo
        
        @Column(name = "serial_number")       
        private String serialNumber;
        
        @Column(name = "fk_id_user")       
        private Integer fkIdUser;
}
