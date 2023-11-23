package com.dci.demo.service;

import com.dci.demo.domain.Recinto;
import com.dci.demo.domain.Reserva;
import com.dci.demo.repository.RecintoRepository;
import com.dci.demo.repository.ReservaRepository;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class GeneradorDePDFService {

    private ReservaService reservaService;
    private RecintoRepository recintoRepository;
    public  GeneradorDePDFService (ReservaService reservaService, RecintoRepository recintoRepository){
        this.reservaService=reservaService;
        this.recintoRepository=recintoRepository;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.decode("#FFE551"));
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);
        //id reserva, fecha inicio, fecha fin, rut usuario, nombre recinto y nombre actividad
        cell.setPhrase(new Phrase("Id reserva", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Fecha inicio", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Fecha fin", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Rut usuario", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Actividad", font));
        table.addCell(cell);
        }
    private void writeTableData(PdfPTable table, Long id, LocalDateTime date){
        List<Reserva> listReserva=reservaService.obtenerReservasPorRecintoYDesde(id,date);
        for (Reserva reserva : listReserva){
            table.addCell(String.valueOf(reserva.getResRecinto().getRecId()));
            table.addCell(String.valueOf(reserva.getResInicio()));
            table.addCell(String.valueOf(reserva.getResFin()));
            table.addCell(reserva.getResUsuario().getUsuRut());
            table.addCell(String.valueOf(reserva.getResActividad().getActNombre()));
        }
    }

    public void export(HttpServletResponse response, Long id, LocalDateTime date) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        Recinto recinto = recintoRepository.findById(id).get();
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLACK);
        Paragraph p = new Paragraph("Reservas de "+recinto.getRecNombre(), font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table, id, date);

        document.add(table);

        document.close();

    }

}
