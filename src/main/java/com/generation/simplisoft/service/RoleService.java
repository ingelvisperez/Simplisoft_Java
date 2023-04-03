package com.generation.simplisoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.generation.simplisoft.model.Role;
import com.generation.simplisoft.repository.RoleRepository;

@Service
@Transactional

public class RoleService {

     /* 
        Necesitamos conectar esta clase con la clase repositorio
        (Lo hacemos declarando una variable de tipo RoleRepository)
        
        Asi ésta clase podrá utilizar 
        los métodos CRUD definidos en la interfaz RoleRepository 
        para interactuar con la base.
    */   

    private RoleRepository roleRepository;

    /* Se crea el constructor de esta clase, que tiene como parámetro
     * un objeto de tipo RoleRepository.
     * 
     * Esto quiere decir que la instancia RoleService que se crea
     * tendrá acceso a un objeto de RoleRepository y así poder 
     * interactuar con la base de datos
     */
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /* --------------------------------- */
    /* Inicio de los métodos de la clase */
    /* --------------------------------- */

    // Método SAVE: se hereda de la interfaz JpaRepository
    /*  Este método permite a la esta clase guardar un nuevo objeto Role
        en la BD usando el objeto RoleRepository que se 
        inyecto en la clase.    
    */ 

    public void saveRole(Role role){
        this.roleRepository.save(role);
    }

    // Método ACTUALIZAR/EDITAR/UPDATE
    public void updateRole(Role role){
        this.roleRepository.save(role);
    }

    // Método para BORRAR/DELETE
    public void deleteRole(Integer id){
        roleRepository.deleteById(id);
    }

    //Método para BUSCAR/ENCONTRAR a TODOS
    public List<Role> findAll(){
        return roleRepository.findAll();
    }


}
