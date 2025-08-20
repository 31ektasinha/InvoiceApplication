package org.application.controller;

import org.application.model.Dealer;
import org.application.model.Invoice;
import org.application.model.Vehicle;
import org.application.service.InvoiceService;
import org.application.utils.PdfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    //private final InvoiceService invoiceService;

    //public InvoiceController(InvoiceService invoiceService) {
        //this.invoiceService = invoiceService;
    //}

    @GetMapping("/invoice")
    public ResponseEntity<byte[]> generateInvoice(@RequestParam String dealerId,
                                                  @RequestParam String vehicleId,
                                                  @RequestParam String customerName) throws Exception {


        Dealer dealer = new Dealer("E1", "Ekta Motors", "Some Street, Pune", "9876543210");
        Vehicle vehicle = new Vehicle("V1", "Reanault", "Corolla", 850000);


        Invoice invoice = invoiceService.createInvoice(dealer, vehicle, customerName);


        byte[] pdf = PdfUtil.generatePdf(invoice);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", invoice.getInvoiceNumber() + ".pdf");
        return ResponseEntity.ok().headers(headers).body(pdf);
    }
}

