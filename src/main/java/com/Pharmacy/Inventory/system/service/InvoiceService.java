package com.Pharmacy.Inventory.system.service;

import com.Pharmacy.Inventory.system.entity.Invoice;
import com.Pharmacy.Inventory.system.entity.Sale;
import com.Pharmacy.Inventory.system.repository.InvoiceRepository;
import com.Pharmacy.Inventory.system.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final SaleRepository saleRepository;

    public InvoiceService(InvoiceRepository invoiceRepository,
                          SaleRepository saleRepository) {
        this.invoiceRepository = invoiceRepository;
        this.saleRepository = saleRepository;
    }
    public Invoice generateInvoice(Long saleId) {

        // 1. find sale
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new RuntimeException("Sale not found"));

        // 2. create invoice
        Invoice invoice = new Invoice();
        invoice.setSaleId(saleId);
        invoice.setTotalAmount(sale.getTotalPrice());
        invoice.setDate(LocalDate.now());

        // 3. save invoice
        return invoiceRepository.save(invoice);
    }
}