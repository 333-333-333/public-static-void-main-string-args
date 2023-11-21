package com.dci.demo.controller;

import com.dci.demo.domain.Reserva;
import com.dci.demo.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservaController {
    private ReservaService reservaService;
    public ReservaController(ReservaService reservaService){
        this.reservaService = reservaService;
    }
    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva){
        return reservaService.crearReserva(reserva);
    }
    @GetMapping("/{id}")
    public Reserva verReservaPorId(@PathVariable Long id){
        return reservaService.verReservaPorId(id);
    }
    @GetMapping("/admin")//?????
    public List<Reserva> verReservas(){
        return  reservaService.obtenerTodasLasReservas();
    }
}
