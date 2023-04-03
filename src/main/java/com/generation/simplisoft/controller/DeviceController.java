package com.generation.simplisoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.simplisoft.model.Device;
import com.generation.simplisoft.model.DeviceRegistroDTO;
import com.generation.simplisoft.service.DeviceService;

//se debe especificar que es una clase de tipo controlador
/*
Es una anotación utilizada para marcar una clase que se encargará 
de manejar solicitudes HTTP y enviar respuestas en forma de objetos
Java serializados en formato JSON o XML.

*/
@Controller
// se debe especificar el origen de las peticiones, en este caso pueden
// venir de cualquier lado!
@CrossOrigin("*")
/*
 * Un controlador de REST, marcado con la anotación @RestController,
 * funciona como una combinación de las anotaciones @Controller y
 * 
 * @ResponseBody
 */
@RestController

public class DeviceController {

    private DeviceService deviceService;

    /*
     * Se inicia el Constructor
     * La anotación @Autowired se puede usar en el constructor
     * para inyectar la instancia de
     * DeviceService en la variable de instancia deviceService.
     * 
     * Esto se hace mediante la funcionalidad de la inyección de
     * dependencias de Spring Framework.
     */
    public DeviceController(@Autowired DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    /* --------------------------------- */
    /* Métodos POST / GET / DELETE / PUT */
    /* --------------------------------- */

    // POST: Método para ingresar/registrar datos a la BD
    @PostMapping("/device/register")
    public void registerDevice(@RequestBody DeviceRegistroDTO deviceRegistroDTO) {
        deviceService.createDevice(deviceRegistroDTO);
    }

    // PUT: Método para editar un equipo en la BD
    @PutMapping("/device/update")
    public void updateDevice(@RequestBody Device device) {
        deviceService.updateDevice(device);
    }

    // DELETE: Método para Eliminar/Borrar un equipo 
    @DeleteMapping("/device/delete/{id}")
    public void deleteDevice(@PathVariable Integer id) {
        deviceService.deleteDevice(id);
    }

    // GET: Método que retorna todos los equipos
    @GetMapping("/device/findAll")
    public List<Device> getDevice() {
        return deviceService.findAll();
    }

    // GET: Métod que retorna todos los equipos asociados a un username
    @GetMapping("/device/{username}")
    public List<Device>findAllDevicesByUsername(@PathVariable String username) {
        return deviceService.findAllDevicesByUsername(username);
    }
    // GET: Retorna cantidad de equipos asociados a un username
    @GetMapping("/device/totalByUser/{username}")
    public Integer numberOfTicketByStatus(@PathVariable String username){
        return deviceService.numberOfTicketByStatus(username);
    }

    // GET: Retorna cantidad de equipos totales
    @GetMapping("/device/total")
    public Integer numberOfDevices(){
        return deviceService.numberOfDevices();
    }


    // GET: Retorna el equipo asociado a una orden a través del id_order
    @GetMapping("/device/byOrder/{id_order}")
    public Device findDeviceByOrder(@PathVariable Integer id_order) {
        return deviceService.findDeviceByOrder(id_order);
    }







}//fin
