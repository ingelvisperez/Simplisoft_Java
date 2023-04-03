package com.generation.simplisoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generation.simplisoft.model.Ticket;

/*  
    Esta sentencia define una interfaz de repositorio para la entidad Ticket utilizando Spring Data JPA. 
    La interfaz extiende la interfaz JpaRepository que proporciona métodos para realizar operaciones 
    CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.
*/

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

    //Query para buscar todos los id_tickets asociados a un username
    @Query(value= "SELECT Tickets.id_ticket FROM Tickets INNER JOIN Users ON Tickets.fk_id_ticketuser = Users.id_user WHERE Users.user_name LIKE ?1", nativeQuery = true)
    List<Integer>findTicketIdByUsername(String username);

    //Query para buscar los tickets asociados a un username
    @Query(value = "SELECT Tickets.id_ticket, Tickets.ticket_creation_date, Tickets.ticket_close_date, Tickets.ticket_status, Tickets.fk_id_ticketuser FROM Tickets INNER JOIN Users ON Tickets.fk_id_ticketuser = Users.id_user WHERE Users.user_name LIKE ?1",nativeQuery = true)
    List<Ticket>findAllTicketByUsername(String username);

    //Query para saber la cantidad de Tickets totales
    @Query(value = "SELECT COUNT(*) FROM Tickets",nativeQuery = true)
    Integer numberOfTickets();

    // Query para saber la cantidad de Tickets asociado a un username
    @Query(value = "SELECT COUNT(*) FROM Tickets INNER JOIN Users ON Users.id_user =Tickets.fk_id_ticketuser WHERE Users.user_name LIKE ?1", nativeQuery = true)
    Integer numberOfTicketsByUsername(String username);

    // Query para saber la cantidad de Tickets por status
    @Query(value = "SELECT COUNT(*) FROM Tickets WHERE Tickets.ticket_status LIKE ?1", nativeQuery = true)
    Integer numberOfTicketByStatus(String status);


}// fin de ticketRepository
