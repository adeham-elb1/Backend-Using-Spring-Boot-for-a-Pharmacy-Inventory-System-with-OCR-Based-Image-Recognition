package com.Pharmacy.Inventory.system.repository;
import java.util.Optional;

import com.Pharmacy.Inventory.system.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    Optional<Medicine> findByNameContainingIgnoreCase(String name);
    Optional<Medicine> findByNameIgnoreCase(String name);
}
