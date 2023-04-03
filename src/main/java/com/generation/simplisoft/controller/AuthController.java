package com.generation.simplisoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.simplisoft.model.Ticket;
import com.generation.simplisoft.model.User;
import com.generation.simplisoft.model.UserRegistroDTO;
import com.generation.simplisoft.service.MyUserDetailsService;

@Controller
@CrossOrigin("*")
@RestController
@RequestMapping("/auth")

public class AuthController {

    // Clase de spring security que permite encriptar contraseña
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Inyección de dependencia del service donde está el método de crear usuario
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    // Endpoint de registro
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRegistroDTO userRegistroDTO) {

        String encryptedPassword = passwordEncoder.encode(userRegistroDTO.getUserPassword()); // Toma la contraseña y la
                                                                                              // encripta

        userRegistroDTO.setUserPassword(encryptedPassword); // La contraseña encriptada se setea a userRegistroDTO

        User usuarioRegistrado = myUserDetailsService.createUser(userRegistroDTO); // Creamos el usuario llamando a
                                                                                   // createUser

        return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);
    }

    // PUT: Para editar datos en la BD
    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        myUserDetailsService.updateUser(user);
    }

    // DELETE: Eliminar/Borrar datos de BD
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        myUserDetailsService.deleteUser(id);
    }

        
    // GET: Para obtener Usuarios registrados en la BD
    @GetMapping("/findAll")
    public List<User> findAll() {
        return myUserDetailsService.findAll();
    }


    // GET: Para obtener los datos de un usuario usando el ID
    @GetMapping("/findUserById/{id_user}")
    public List<User> findUserById(@PathVariable Integer id_user) {
        return myUserDetailsService.findUserById(id_user);
    }

    // GET: Para obtener los datos de un usuario usando el Rut
    @GetMapping("/findUserByRut/{rut}")
    public List<User> findUserByRut(@PathVariable String rut) {
        return myUserDetailsService.findUserByRut(rut);
    }

    // GET: Para buscar el username y password de un usuario usando el username
    @GetMapping("/findUserByUsername/{username}")
    public UserDetails findUserByUsername(@PathVariable String username){
        return myUserDetailsService.loadUserByUsername(username);
    }
 
    // GET: Retorna la cantidad de usuarios registrados en la DB
    @GetMapping("/total")
    public Integer numberOfUsers(){
        return myUserDetailsService.numberOfUsers();
    }

    // GET: Retorna la cantidad de usuarios por role
    @GetMapping("/totalByRole/{role}")
    public Integer numberOfUserstByRole(@PathVariable String role){
       return myUserDetailsService.numberOfUserstByRole(role);
    }  

    // GET: Retorna a los usuarios segun su role
    @GetMapping("/byRole/{role}")
    public List<User> UserstByRole(@PathVariable String role){
        return myUserDetailsService.UserstByRole(role);
    }

} // Fin de AuthController
