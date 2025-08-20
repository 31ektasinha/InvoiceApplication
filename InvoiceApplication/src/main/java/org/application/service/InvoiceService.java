package org.application.service;

import org.application.model.Dealer;
import org.application.model.Invoice;
import org.application.model.Vehicle;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class InvoiceService {
    public Invoice createInvoice(Dealer dealer, Vehicle vehicle, String customerName) {
        double tax = vehicle.getPrice() * 0.10;
        double total = vehicle.getPrice() + tax;

        String invoiceNumber = "INV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        return new Invoice(invoiceNumber, dealer.getName(), customerName,
                vehicle.getMake() + " " + vehicle.getModel(),
                vehicle.getPrice(), tax, total, LocalDateTime.now());
    }
}


