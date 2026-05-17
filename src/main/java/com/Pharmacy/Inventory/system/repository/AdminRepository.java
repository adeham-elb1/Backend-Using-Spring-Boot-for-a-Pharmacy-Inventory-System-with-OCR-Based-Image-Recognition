package com.Pharmacy.Inventory.system.repository;

import com.Pharmacy.Inventory.system.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}