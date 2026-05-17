package com.Pharmacy.Inventory.system.controller;

import com.Pharmacy.Inventory.system.entity.Sale;
import com.Pharmacy.Inventory.system.service.SaleService;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/sale")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/sell")
    public Sale sell(@RequestParam Long medicineId,
                     @RequestParam int quantity) {

        return saleService.createSale(medicineId, quantity);
    }
}