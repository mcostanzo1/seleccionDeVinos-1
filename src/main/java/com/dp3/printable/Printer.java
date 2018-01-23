package com.dp3.printable;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;

public class Printer {

    Printable print;

    public Printer(Printable print) {
        this.print = print;
    }

    public ResponseEntity<byte[]> print() throws DocumentException {
        byte[] contents = retrieveDocument(this.print);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String pdfName = this.print.getPdfName();
        headers.setContentDispositionFormData(pdfName, pdfName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }

    private byte[] retrieveDocument(Printable printable) throws DocumentException {
        Document doc = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(doc, byteArrayOutputStream);
        doc.open();
        printable.getDocument(doc);
        doc.close();
        writer.close();
        return byteArrayOutputStream.toByteArray();
    }

}
