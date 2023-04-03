package com.generation.simplisoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.generation.simplisoft.model.Device;
import com.generation.simplisoft.model.DeviceRegistroDTO;
import com.generation.simplisoft.repository.DeviceRepository;

@Service
@Transactional

public class DeviceService {

     /* 
        Necesitamos conectar esta clase con la clase repositorio
        (Lo hacemos declarando una variable de tipo DeviceRepository)
        
        Asi ésta clase podrá utilizar 
        los métodos CRUD definidos en la interfaz DeviceRepository 
        para interactuar con la base.
    */   

    private DeviceRepository deviceRepository;

    /* Se crea el constructor de esta clase, que tiene como parámetro
     * un objeto de tipo DeviceRepository.
     * 
     * Esto quiere decir que la instancia DeviceService que se crea
     * tendrá acceso a un objeto de DeviceRepository y así poder 
     * interactuar con la base de datos
     */
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    /* --------------------------------- */
    /* Inicio de los métodos de la clase */
    /* --------------------------------- */

    // Método SAVE: se hereda de la interfaz JpaRepository
    /*  Este método permite a la esta clase guardar un nuevo objeto device
        en la BD usando el objeto DeviceRepository que se 
        inyecto en la clase.    
    */ 

    //Método para crear un nuevo dispositivo
    public Device createDevice(DeviceRegistroDTO deviceRegistroDTO) {
        Device deviceCreation = new Device();
        deviceCreation.setDeviceType(deviceRegistroDTO.getDeviceType());
        deviceCreation.setDeviceBrand(deviceRegistroDTO.getDeviceBrand());
        deviceCreation.setDeviceModel(deviceRegistroDTO.getDeviceModel());
        deviceCreation.setSerialNumber(deviceRegistroDTO.getSerialNumber());
        deviceCreation.setFkIdUser(deviceRegistroDTO.getFkIdUser());
        return deviceRepository.save(deviceCreation);
    }

    // Método ACTUALIZAR/EDITAR/UPDATE
    public void updateDevice(Device device){
        this.deviceRepository.save(device);
    }

    // Método para BORRAR/DELETE
    public void deleteDevice(Integer id){
        deviceRepository.deleteById(id);
    }

    //Método para BUSCAR/ENCONTRAR a TODOS
    public List<Device> findAll(){
        return deviceRepository.findAll();
    }

    // Método para buscar los equipos asociados a un username
    public List<Device> findAllDevicesByUsername(String username){
        return deviceRepository.findAllDevicesByUsername(username);
    }

    // Método para saber la cantidad de equipos totales
    public Integer numberOfDevices(){
        return deviceRepository.numberOfDevices();
    }

    // Método para saber la cantidad de equipos asociados a un username
    public Integer numberOfTicketByStatus(String username){
        return deviceRepository.numberOfDevicesByUsername(username) ;
    }

    // Método que retorna el equipo asociado a una orden a través del id_order
    public Device findDeviceByOrder(Integer id_order){
        return deviceRepository.findDeviceByOrder(id_order);
    }


}//fin