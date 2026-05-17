package com.Pharmacy.Inventory.system.repository;

import com.Pharmacy.Inventory.system.entity.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {
}