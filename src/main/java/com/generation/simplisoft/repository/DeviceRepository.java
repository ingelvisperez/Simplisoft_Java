package com.generation.simplisoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generation.simplisoft.model.Device;

/*  
    Esta sentencia define una interfaz de repositorio para la entidad Device utilizando Spring Data JPA. 
    La interfaz extiende la interfaz JpaRepository que proporciona métodos para realizar operaciones 
    CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.
*/

public interface DeviceRepository extends JpaRepository<Device, Integer> {

    // @Query(value = "", nativeQuery = true)

    // Query para buscar los equipos asociados a un username
    @Query(value = "SELECT devices.id_device, devices.device_type, devices.device_brand, devices.device_model, devices.serial_number, devices.fk_id_user FROM devices INNER JOIN Users ON Users.id_user = devices.fk_id_user WHERE Users.user_name LIKE ?1", nativeQuery = true)
    List<Device> findAllDevicesByUsername(String username);
    
    // Query para saber la cantidad de equipos asociado a un username
    @Query(value = "SELECT COUNT(*) FROM Devices INNER JOIN Users ON Users.id_user = Devices.fk_id_user WHERE  Users.user_name LIKE ?1", nativeQuery = true)
    Integer numberOfDevicesByUsername(String username);

    // Query para saber la cantidad de equipos registrado en la DB
    @Query(value = "SELECT COUNT(*) FROM devices", nativeQuery = true)
    Integer numberOfDevices();

    // -- Query que retorna el equipo asociado a una orden a través del id_order
    
    @Query(value = "SELECT * FROM Devices INNER JOIN Orders ON Devices.id_device = Orders.fk_id_device WHERE Orders.id_order_service LIKE ?1", nativeQuery = true)
    Device findDeviceByOrder(Integer id_order);





    
}// fin
