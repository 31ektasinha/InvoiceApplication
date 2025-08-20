package org.application.model;

import java.time.LocalDateTime;

public class Invoice {
    private String invoiceNumber;
    private String dealerName;
    private String customerName;
    private String vehicleDetails;
    private double basePrice;
    private double tax;
    private double total;
    private LocalDateTime createdAt;

    public Invoice(String invoiceNumber, String dealerName, String customerName,
                   String vehicleDetails, double basePrice, double tax, double total, LocalDateTime createdAt) {
        this.invoiceNumber = invoiceNumber;
        this.dealerName = dealerName;
        this.customerName = customerName;
        this.vehicleDetails = vehicleDetails;
        this.basePrice = basePrice;
        this.tax = tax;
        this.total = total;
        this.createdAt = createdAt;
    }

    // getters
    public String getInvoiceNumber() { return invoiceNumber; }
    public String getDealerName() { return dealerName; }
    public String getCustomerName() { return customerName; }
    public String getVehicleDetails() { return vehicleDetails; }
    public double getBasePrice() { return basePrice; }
    public double getTax() { return tax; }
    public double getTotal() { return total; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}

