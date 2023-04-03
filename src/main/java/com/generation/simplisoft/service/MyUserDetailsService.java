package com.generation.simplisoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.simplisoft.model.User;
import com.generation.simplisoft.model.UserRegistroDTO;
import com.generation.simplisoft.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    // Inyección de dependencias que hacemos para poder acceder a los métodos del
    // repository desde esta clase
    @Autowired
    private UserRepository userRepository;

    // Método para buscar el username y password de un usuario usando el username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }
    /*  // Método para buscar el email y password de un usuario usando el username
         @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }
     */

    // Metodo para crear/registrar un usuario

    public User createUser(UserRegistroDTO userRegistroDTO) {
        User userCreation = new User();
        userCreation.setRut(userRegistroDTO.getRut());
        userCreation.setUsername(userRegistroDTO.getUsername());
        userCreation.setUserPassword(userRegistroDTO.getUserPassword());
        userCreation.setEmail(userRegistroDTO.getEmail());
        userCreation.setAddress(userRegistroDTO.getAddress());
        userCreation.setPhone(userRegistroDTO.getPhone());

        return userRepository.save(userCreation);
    }

    // Método ACTUALIZAR/EDITAR/UPDATE
    public void updateUser(User user) {
        this.userRepository.save(user);
    }

    // Método para BORRAR/DELETE
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // Método para BUSCAR/ENCONTRAR a TODOS
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Método para BUSCAR un usuario por Id
    public List<User> findUserById(Integer id_user) {
        return userRepository.findUserByID(id_user);
    }

    // Metodo para encontrar un usuario por el Rut
    public List<User> findUserByRut(String rut) {
        return userRepository.findUserByRut(rut);
    }

    // Método que retorna la cantidad de usuarios registrados en DB
    public Integer numberOfUsers(){
        return userRepository.numberOfUsers();
    }

    // Método que retorna la cantidad de Userios por role
    public Integer numberOfUserstByRole(String role){
        return userRepository.numberOfUserstByRole(role);
    }

    // Método que retorna a los usuarios segun su role
    public List<User> UserstByRole(String role){
        return userRepository.UserstByRole(role);
    }


}// Fin de MyUserDetailsService
