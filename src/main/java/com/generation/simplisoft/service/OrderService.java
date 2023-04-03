package com.generation.simplisoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.generation.simplisoft.model.Order;
import com.generation.simplisoft.model.OrderRegistroDTO;
import com.generation.simplisoft.repository.OrderRepository;

@Service
@Transactional

public class OrderService {

    /*
     * Necesitamos conectar esta clase con la clase repositorio
     * (Lo hacemos declarando una variable de tipo OrderRepository)
     * 
     * Asi ésta clase podrá utilizar
     * los métodos CRUD definidos en la interfaz OrderRepository
     * para interactuar con la base.
     */

    private OrderRepository orderRepository;

    /*
     * Se crea el constructor de esta clase, que tiene como parámetro
     * un objeto de tipo OrderRepository.
     * 
     * Esto quiere decir que la instancia OrderService que se crea
     * tendrá acceso a un objeto de OrderRepository y así poder
     * interactuar con la base de datos
     */
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /* --------------------------------- */
    /* Inicio de los métodos de la clase */
    /* --------------------------------- */

    // Método SAVE: se hereda de la interfaz JpaRepository
    /*
     * Este método permite a la esta clase guardar un nuevo objeto order
     * en la BD usando el objeto OrderRepository que se
     * inyecto en la clase.
     */

    // public void saveOrder(Order order){
    // this.orderRepository.save(order);
    // }

    // Método para crear una nueva orden
    public Order createOrder(OrderRegistroDTO orderRegistroDTO) {
        Order orderCreation = new Order();
        orderCreation.setCommentInitial(orderRegistroDTO.getCommentInitial());
        orderCreation.setCommentTechnical(orderRegistroDTO.getCommentTechnical());
        orderCreation.setCommentClient(orderRegistroDTO.getCommentClient());
        orderCreation.setFiles(orderRegistroDTO.getFiles());
        orderCreation.setStatusOrder(orderRegistroDTO.getStatusOrder());
        orderCreation.setOrderCreationDate(orderRegistroDTO.getOrderCreationDate());
        orderCreation.setOrderCloseDate(orderRegistroDTO.getOrderCloseDate());
        orderCreation.setFkIdDevice(orderRegistroDTO.getFkIdDevice());
        orderCreation.setFkIdTicket(orderRegistroDTO.getFkIdTicket());

        return orderRepository.save(orderCreation);
    }

    // Método ACTUALIZAR/EDITAR/UPDATE
    public void updateOrder(Order order) {
        this.orderRepository.save(order);
    }

    // Método para BORRAR/DELETE
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    // Método para BUSCAR/ENCONTRAR a TODOS
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    // Método que retorna la orden asociada a un ticket
    public List<Order>  findOrderByIdTicket(Integer id_ticket){
        return orderRepository.findOrderByIdTicket(id_ticket);
    }

    // Método que retorna los id_order asociados a un ticket
    public List<Integer> findIdOrderByIdTicket(Integer id_ticket){
        return orderRepository.findIdOrderByIdTicket(id_ticket);
    }

    // Método para saber la cantidad de ordenes totales en BD
    public Integer numberOfOrders(){
        return orderRepository.numberOfOrders();
    }

    // Método para saber la cantidad de ordenes por status
    public Integer numberOfOrdersByStatus(String status){
        return orderRepository.numberOfOrdersByStatus(status);
    }




    // Método para saber la cantidad de Ordenes asociadas a un status


    
    
}
