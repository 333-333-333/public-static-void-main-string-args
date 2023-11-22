package com.dci.demo.controller;

import com.dci.demo.domain.Reserva;
import com.dci.demo.service.ReservaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/reservas/")
public class ReservaController {
    private ReservaService reservaService;
    public ReservaController(ReservaService reservaService){
        this.reservaService = reservaService;
    }
    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva){
        return reservaService.crearReserva(reserva);
    }
    @GetMapping("{id}")
    public Reserva verReservaPorId(@PathVariable Long id){
        return reservaService.verReservaPorId(id);
    }
    @GetMapping("admin")//?????
    public List<Reserva> verReservas(){
        return  reservaService.obtenerTodasLasReservas();
    }

    // recibir de parametro un recinto, una fecha y q apartir de entregue los horarios disponibles.

    /*@GetMapping("disponibles")
    public ResponseEntity<?> obtenerHorariosDisponibles(
            @RequestParam Long recId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
        try {
            List<Date> horariosDisponibles = reservaService.obtenerHorariosDisponibles(recId, fecha);
            return ResponseEntity.ok(horariosDisponibles);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }*/

}
