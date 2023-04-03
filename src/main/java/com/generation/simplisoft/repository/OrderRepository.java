package com.generation.simplisoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generation.simplisoft.model.Order;

/*  
    Esta sentencia define una interfaz de repositorio para la entidad Order utilizando Spring Data JPA. 
    La interfaz extiende la interfaz JpaRepository que proporciona métodos para realizar operaciones 
    CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.
*/

public interface OrderRepository extends JpaRepository<Order, Integer>{
    //NOTA: Aqui van las consultas personalizadas

    // Query que retorna la orden asociada a un ticket
    @Query(value = "SELECT Orders.id_order_service, Orders.comment_initial, Orders.comment_technical, Orders.comment_client, Orders.files, Orders.status_order, Orders.order_creation_date, Orders.order_close_date, Orders.fk_id_device, Orders.fk_id_ticket FROM Orders INNER JOIN Tickets ON Orders.fk_id_ticket  = Tickets.id_ticket WHERE Tickets.id_ticket LIKE ?1", nativeQuery = true)
    List<Order> findOrderByIdTicket(Integer id_ticket);

    //Query que retorna los id_order asociados a un ticket
    @Query(value = "SELECT Orders.id_order_service FROM Orders INNER JOIN Tickets ON Orders.fk_id_ticket  = Tickets.id_ticket WHERE Tickets.id_ticket LIKE ?1", nativeQuery = true)
    List<Integer> findIdOrderByIdTicket(Integer id_ticket);

    // Query para saber la cantidad de ordenes totales en BD
    @Query(value = "SELECT COUNT(*) FROM Orders",nativeQuery = true)
    Integer numberOfOrders();

    // Query para saber la cantidad de Ordenes asociadas a un status
    @Query(value = "SELECT COUNT(*) FROM Orders WHERE Orders.status_order LIKE ?1", nativeQuery = true)
    Integer numberOfOrdersByStatus(String status);

/*
     

    // Query para saber la cantidad de Tickets por status
    @Query(value = "SELECT COUNT(*) FROM Tickets WHERE Tickets.ticket_status LIKE ?1", nativeQuery = true)
    Integer numberOfTicketByStatus(String status);
 */




}// fin
