package com.Pharmacy.Inventory.system.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public class Sale {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long  medicineId;
    private int quantity;
    private double totalPrice;
    private LocalDateTime date;

    public Sale() {}

}







