package com.Pharmacy.Inventory.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Invoice {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private Long saleId;
 private Double totalAmount;
 private LocalDate date;


    public Invoice() {}


}
