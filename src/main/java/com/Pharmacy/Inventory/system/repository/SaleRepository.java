package com.Pharmacy.Inventory.system.repository;

import com.Pharmacy.Inventory.system.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}