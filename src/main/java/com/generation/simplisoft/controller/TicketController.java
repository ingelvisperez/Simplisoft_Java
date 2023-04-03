package com.generation.simplisoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.simplisoft.model.Ticket;
import com.generation.simplisoft.service.TicketService;

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

public class TicketController {

    public TicketService ticketService;

    /*
     * Se inicia el Constructor
     * La anotación @Autowired se puede usar en el constructor
     * para inyectar la instancia de
     * TicketService en la variable de instancia ticketService.
     * 
     * Esto se hace mediante la funcionalidad de la inyección de
     * dependencias de Spring Framework.
     */

    public TicketController(@Autowired TicketService ticketService) {
        this.ticketService = ticketService;
    }
    /* --------------------------------- */
    /* Métodos POST / GET / DELETE / PUT */
    /* --------------------------------- */

    // POST: Se usa para Registrar un tickets
    @PostMapping("/ticket/save")
    public void saveTicket(@RequestBody Ticket ticket) {
        ticketService.saveTicket(ticket);
    }

    // PUT: Se usa para editar un ticket
    @PutMapping("/ticket/update")
    public void updateTicket(@RequestBody Ticket ticket) {
        ticketService.updateTicket(ticket);
    }

    // DELETE: Eliminar/Borrar un ticket asociado a un id
    @DeleteMapping("/ticket/delete/{id}")
    public void deleteTicket(@PathVariable Integer id) {
        ticketService.deleteTicket(id);
    }

    // GET: Retorna todos los tickets
    @GetMapping("/ticket/findAll")
    public List<Ticket> getTicket() {
        return ticketService.findAll();
    }

    // GET: Retorna los id_tickets asociados a un username
    @GetMapping("/ticket/id/{username}")
    public List<Integer> getTicketIdWithUsername(@PathVariable String username) {
        return ticketService.findTicketIdByUsername(username);
    }

    // GET: Retorna los tickets asociados a un username
    @GetMapping("/ticket/{username}")
    public List<Ticket> getAllTicketByUsername(@PathVariable String username) {
        return ticketService.findAllTicketByUsername(username);
    }

    // GET: Retorna cantidad de tickets totales
    @GetMapping("/ticket/total")
    public Integer  numberOfTickets(){
        return ticketService.numberOfTickets();
    }

    // GET: Retorna cantidad de tickets asociados a un usuario
    @GetMapping("/ticket/totalByUser/{username}")
    public Integer numberOfTicketsByUsername(@PathVariable String username){
        return ticketService.numberOfTicketsByUsername(username);
    }

    // GET: Retorna cantidad de tickets por status
    @GetMapping("/ticket/totalByStatus/{status}")
    public Integer numberOfTicketByStatus(@PathVariable String status){
        return ticketService.numberOfTicketByStatus(status);
    }


    
}// fin del ticketController
