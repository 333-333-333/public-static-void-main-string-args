package com.dci.demo.controller;

import com.dci.demo.domain.Reserva;
import com.dci.demo.service.ReservaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservas/")
@CrossOrigin(origins = "*")
public class ReservaController {


    private ReservaService ReservaService;

    public ReservaController(ReservaService ReservaService){
        this.ReservaService = ReservaService;
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

    @GetMapping("{recId}/{resInicio}")
    public ResponseEntity<?> verReservasPorRecintoYDesde(@PathVariable Long recId, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date resInicio) {
        List<Reserva> reservas = ReservaService.obtenerReservasPorRecintoYDesde(recId, resInicio);
        return ResponseEntity.ok(reservas);
    }


}
