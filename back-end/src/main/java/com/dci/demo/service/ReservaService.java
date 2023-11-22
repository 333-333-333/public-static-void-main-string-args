package com.dci.demo.service;

import com.dci.demo.domain.Reserva;
import com.dci.demo.repository.ReservaRepository;
import com.dci.demo.util.Validador;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservaService {


    private ReservaRepository ReservaRepository;

    public ReservaService (ReservaRepository ReservaRepository){
        this.ReservaRepository = ReservaRepository;
    }

    public Reserva crearReserva(Reserva reserva){
        if (!Validador.validarReserva(reserva)) {

        }
        return ReservaRepository.save(reserva);
    }

    public Reserva verReservaPorId(Long id){
        return ReservaRepository.findById(id).orElse(null);
    }

    public List<Reserva> obtenerTodasLasReservas(){
        return ReservaRepository.findAll();
    }


    public List<Reserva> obtenerReservasPorRecinto(Long recId){
        return ReservaRepository.findReservasByRecinto(recId);
    }

    public List<Reserva> obtenerReservasPorRecintoYDesde(Long recId, Date resInicio){
        return ReservaRepository.findReservasByRecintoAndInicio(recId, resInicio);
    }


}
