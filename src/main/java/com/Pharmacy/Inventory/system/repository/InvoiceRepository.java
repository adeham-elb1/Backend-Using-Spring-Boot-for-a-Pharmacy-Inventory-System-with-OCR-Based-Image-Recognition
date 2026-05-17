package com.Pharmacy.Inventory.system.repository;

import com.Pharmacy.Inventory.system.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
