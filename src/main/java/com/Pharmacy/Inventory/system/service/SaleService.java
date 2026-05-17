package com.Pharmacy.Inventory.system.service;

import com.Pharmacy.Inventory.system.entity.Sale;
import com.Pharmacy.Inventory.system.entity.Medicine;
import com.Pharmacy.Inventory.system.repository.SaleRepository;
import com.Pharmacy.Inventory.system.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final MedicineRepository medicineRepository;

    public SaleService(SaleRepository saleRepository,
                       MedicineRepository medicineRepository) {
        this.saleRepository = saleRepository;
        this.medicineRepository = medicineRepository;
    }

    public Sale createSale(Long medicineId, int qty) {

        // 1. find medicine
        Medicine m = medicineRepository.findById(medicineId)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));

        // 2. check stock
        if (m.getQuantity() < qty) {
            throw new RuntimeException("Not enough stock");
        }

        // 3. reduce stock
        m.setQuantity(m.getQuantity() - qty);
        medicineRepository.save(m);

        // 4. create sale
        Sale sale = new Sale();
        sale.setMedicineId(medicineId);
        sale.setQuantity(qty);
        sale.setTotalPrice(m.getPrice() * qty);
        sale.setDate(LocalDateTime.now());

        // 5. save sale
        return saleRepository.save(sale);
    }
}