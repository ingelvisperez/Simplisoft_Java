package com.generation.simplisoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.generation.simplisoft.model.Ticket;
import com.generation.simplisoft.repository.TicketRepository;

@Service
@Transactional

public class TicketService {

     /* 
        Necesitamos conectar esta clase con la clase repositorio (Lo hacemos declarando una variable de tipo TicketRepository)
        Asi ésta clase podrá utilizar. los métodos CRUD definidos en la interfaz TicketRepository para interactuar con la base.
    */   

    private TicketRepository ticketRepository;

    /* Se crea el constructor de esta clase, que tiene como parámetro un objeto de tipo TicketRepository.
     * Esto quiere decir que la instancia TicketService que se crea tendrá acceso a un objeto de TicketRepository y así poder 
     * interactuar con la base de datos
     */
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    /* --------------------------------- */
    /* Inicio de los métodos de la clase */
    /* --------------------------------- */

    public void saveTicket(Ticket ticket){
        this.ticketRepository.save(ticket);
    }

    // Método ACTUALIZAR/EDITAR/UPDATE
    public void updateTicket(Ticket ticket){
        this.ticketRepository.save(ticket);
    }

    // Método para BORRAR/DELETE
    public void deleteTicket(Integer id){
        ticketRepository.deleteById(id);
    }

    //Método para BUSCAR/ENCONTRAR a TODOS
    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    //retorna los id_tickets usando el username
    public List<Integer> findTicketIdByUsername(String username){
        return ticketRepository.findTicketIdByUsername(username);
    }
    //Retorna los tickets asociados a un username
    public List<Ticket> findAllTicketByUsername(String username) {
        return ticketRepository.findAllTicketByUsername(username);
    }

    //Retorna la cantidad de tickets totales
    public Integer numberOfTickets(){
        return ticketRepository.numberOfTickets();
    }

    // Retorna la cantidad de tickets asociados a un username
    public Integer numberOfTicketsByUsername(String username){
        return ticketRepository.numberOfTicketsByUsername(username);
    }

    // Retorna la cantidad de tickets por status
    public Integer numberOfTicketByStatus(String status){
        return ticketRepository.numberOfTicketByStatus(status);
    }
    




}// fin de TicketService