package com.Pharmacy.Inventory.system.service;

import com.Pharmacy.Inventory.system.entity.Medicine;
import com.Pharmacy.Inventory.system.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
// Manage this class automatically as a Bean
@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

      // Constructor Injection
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public Medicine addMedicine(String name, int qty, double price) {
        Medicine m = new Medicine();
        m.setName(name);
        m.setQuantity(qty);
        m.setPrice(price);
        m.setCreatedAt(LocalDateTime.now());
        m.setUpdatedAt(LocalDateTime.now());
        return medicineRepository.save(m);
    }

    public Medicine updateStock(Long id, int qty) {
        Medicine m = medicineRepository.findById(id).orElseThrow();
        m.setQuantity(qty);
        m.setUpdatedAt(LocalDateTime.now());
        return medicineRepository.save(m);
    }
    public Medicine findMedicineByName(String name) {
        return medicineRepository.findByNameIgnoreCase(name)
                .orElse(null);
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }
}