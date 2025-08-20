package org.application.utils;


import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.application.model.Invoice;

import java.io.ByteArrayOutputStream;

public class PdfUtil {
    public static byte[] generatePdf(Invoice invoice) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document doc = new Document();
        PdfWriter.getInstance(doc, baos);
        doc.open();

        doc.add(new Paragraph("Vehicle Sale Invoice", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
        doc.add(new Paragraph("Invoice Number: " + invoice.getInvoiceNumber()));
        doc.add(new Paragraph("Date: " + invoice.getCreatedAt()));
        doc.add(new Paragraph(" "));

        doc.add(new Paragraph("Dealer: " + invoice.getDealerName()));
        doc.add(new Paragraph("Customer: " + invoice.getCustomerName()));
        doc.add(new Paragraph("Vehicle: " + invoice.getVehicleDetails()));
        doc.add(new Paragraph("Base Price: " + invoice.getBasePrice()));
        doc.add(new Paragraph("Tax (10%): " + invoice.getTax()));
        doc.add(new Paragraph("Total: " + invoice.getTotal()));

        doc.add(new Paragraph(" "));
        doc.add(new Paragraph("Thank you for your purchase!"));

        doc.close();
        return baos.toByteArray();
    }
}

