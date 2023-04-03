package com.generation.simplisoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import java.util.Collection;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Users") // Se usa para comunicarnos con la tabla que queremos, en este caso "Roles"

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User implements UserDetails{
      
    /* Atributos de la clase User */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto para indicarle a la tabla que ID es autoincrementable
        @Column(name = "id_user")        
        private Integer idUser;
               
        private String rut;
        @Column(name = "user_name")                
        private String username;
        
        @Column(name = "user_password")               
        private String userPassword;
          
        @Email
        private String email;
                
        private String address;
        
        @Column(name = "user_status")               
        private Boolean userStatus; // Usuario Activo(1) o  Inactivo (0)
               
        private String phone;
        
        @Column(name = "fk_id_role")                      
        private Integer fkIdRole;

    /* Métodos generados de la implementación UserDetails */
        private boolean accountNonLocked;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(() -> "Read");
        }

        @Override
        public String getPassword() {
            return userPassword;
        }

        @Override
        public String getUsername() {
            return username;
                    
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        // @Override
        public boolean isAccountNonLocked() {
            return accountNonLocked;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
        
        public boolean getAccountNonLocked() {
            return accountNonLocked;
        }
}
