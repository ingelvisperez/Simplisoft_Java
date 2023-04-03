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
public class DeviceRegistroDTO {
    
    private String deviceType;    //tipo de dispositivo
    private String deviceBrand;   // marca del dispositivo
    private String deviceModel;   // Modelo del dispositivo
    private String serialNumber;  // Numero de serie
    private Integer fkIdUser;     //indicar a que usuario pertencece el equipo

}
