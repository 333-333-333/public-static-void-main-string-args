package com.dci.demo.controller;

import com.dci.demo.domain.Reserva;
import com.dci.demo.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas/")
@CrossOrigin(origins = "*")
public class ReservaController {

    private ReservaService ReservaService;

    public ReservaController(ReservaService reservaService){
        this.ReservaService = reservaService;
    }

    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva){
        return ReservaService.crearReserva(reserva);
    }

    @GetMapping("{id}")
    public Reserva verReservaPorId(@PathVariable Long id){
        return ReservaService.verReservaPorId(id);
    }

    @GetMapping("admin")//?????
    public List<Reserva> verReservas(){
        return  ReservaService.obtenerTodasLasReservas();
    }

    // Obtiene las reservas por resinto, y desde el dia y hora en cuestión en adelante.
    //@GetMapping("{recId}/{resInicio}")



}
