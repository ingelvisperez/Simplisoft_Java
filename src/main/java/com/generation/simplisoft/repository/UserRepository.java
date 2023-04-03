package com.generation.simplisoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generation.simplisoft.model.User;

/*  
    Esta sentencia define una interfaz de repositorio para la entidad User utilizando Spring Data JPA. 
    La interfaz extiende la interfaz JpaRepository que proporciona métodos para realizar operaciones 
    CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.
*/

public interface UserRepository extends JpaRepository<User, Integer>{
     //NOTA: Aqui van las consultas personalizadas

     // Query que retorna a un usuario segun su id
     @Query(value = "SELECT * FROM Users WHERE id_user = ?1", nativeQuery = true)
     List <User> findUserByID(Integer id_user);
    // Query que retorna a un usuario segun su RUT
     @Query(value= "SELECT * FROM Users WHERE rut LIKE ?1", nativeQuery = true)
     List<User> findUserByRut(String rut);

     // Para buscar el username y password de un usuario usando el username
     User findUserByUsername(String username);

    // Para buscar un usuario por su email
     User findUserByEmail(String email);

    // Query que retorna la cantidad de usuarios registrados en DB
    @Query(value = "SELECT COUNT(*) FROM Users", nativeQuery = true)
    Integer numberOfUsers();

    // Query para saber la cantidad de Usuarios por role
    @Query(value = "SELECT COUNT(*) FROM Users INNER JOIN Roles ON Users.fk_id_role = Roles.id_role WHERE Roles.role_name LIKE ?1", nativeQuery = true)
    Integer numberOfUserstByRole(String role);

    // Query que retorna a los usuarios segun su role
    @Query(value = "SELECT Users.id_user, Users.rut, Users.user_name, Users.user_password, Users.email, Users.address, Users.user_status, Users.phone, Users.fk_id_role, Users.account_non_locked FROM Users INNER JOIN Roles ON Users.fk_id_role = Roles.id_role WHERE Roles.role_name LIKE ?1", nativeQuery = true)
    List<User> UserstByRole(String role);



}//Fin 
