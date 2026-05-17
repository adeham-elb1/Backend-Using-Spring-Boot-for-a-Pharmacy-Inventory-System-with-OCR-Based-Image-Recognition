package com.Pharmacy.Inventory.system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
// Defines how inheritance is stored in database
// JOINED strategy: each class has its own table linked by the same ID
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String username;
     private String password;
     private String role ;


     public User() {}

}


/*User
       /    \
Pharmacist  Admin\
 */