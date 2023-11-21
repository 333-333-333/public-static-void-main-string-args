package com.dci.demo.service;

import com.dci.demo.domain.Reserva;
import com.dci.demo.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {


    private ReservaRepository reservaRepository;

    public ReservaService (ReservaRepository reservaRepository){
        this.reservaRepository = reservaRepository;
    }

    public Reserva crearReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    public Reserva verReservaPorId(Long id){
        return reservaRepository.findById(id).orElse(null);
    }

    public List<Reserva> obtenerTodasLasReservas(){
        return reservaRepository.findAll();
    }


}
