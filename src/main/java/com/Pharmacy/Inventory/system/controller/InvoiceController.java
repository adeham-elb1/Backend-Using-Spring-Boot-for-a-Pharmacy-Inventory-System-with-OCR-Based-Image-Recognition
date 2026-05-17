package com.Pharmacy.Inventory.system.controller;

import com.Pharmacy.Inventory.system.entity.Invoice;
import com.Pharmacy.Inventory.system.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/generate")
    public Invoice generate(@RequestParam Long saleId) {
        return invoiceService.generateInvoice(saleId);
    }
}