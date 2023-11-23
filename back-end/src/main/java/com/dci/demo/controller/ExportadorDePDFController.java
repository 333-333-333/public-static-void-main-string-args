package com.dci.demo.controller;

import com.dci.demo.service.GeneradorDePDFService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/pdf/")
public class ExportadorDePDFController {

    private GeneradorDePDFService generadorDePDFService;

    public ExportadorDePDFController(GeneradorDePDFService generadorDePDFService) {
        this.generadorDePDFService = generadorDePDFService;
    }


    @GetMapping("{id}/{date}")
    public void generatePDF(HttpServletResponse response, @PathVariable Long id, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss") LocalDateTime date) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.generadorDePDFService.export(response, id, date);
    }
}