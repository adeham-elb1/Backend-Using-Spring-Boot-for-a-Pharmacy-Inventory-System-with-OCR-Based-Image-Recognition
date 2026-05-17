package com.Pharmacy.Inventory.system.service;

import com.Pharmacy.Inventory.system.entity.Sale;
import com.Pharmacy.Inventory.system.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final SaleRepository saleRepository;

    public AdminService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getReports() {
        return saleRepository.findAll();
    }
}