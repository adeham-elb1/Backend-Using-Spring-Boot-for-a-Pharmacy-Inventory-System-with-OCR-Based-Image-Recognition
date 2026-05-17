package com.Pharmacy.Inventory.system.controller;

import com.Pharmacy.Inventory.system.entity.Medicine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Pharmacy.Inventory.system.service.MedicineService;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    // ADD MEDICINE
    @PostMapping("/add")
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine) {
        return ResponseEntity.ok(
                medicineService.addMedicine(
                        medicine.getName(),
                        medicine.getQuantity(),
                        medicine.getPrice()
                )
        );
    }

    // GET ALL MEDICINES
    @GetMapping
    public ResponseEntity<List<Medicine>> getAll() {
        return ResponseEntity.ok(medicineService.getAllMedicines());
    }
    // DELETE MEDICINE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.ok().build();
    }




    // UPDATE STOCK
    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateStock(
            @PathVariable Long id,
            @RequestBody Medicine medicine) {

        return ResponseEntity.ok(
                medicineService.updateStock(id, medicine.getQuantity())
        );
    }
}