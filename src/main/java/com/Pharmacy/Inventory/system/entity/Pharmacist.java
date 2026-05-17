package com.Pharmacy.Inventory.system.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pharmacist extends User {


private String employeeCode;
public Pharmacist() {}



}
