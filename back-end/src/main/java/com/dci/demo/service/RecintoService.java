package com.dci.demo.service;

import com.dci.demo.domain.Recinto;
import com.dci.demo.repository.RecintoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecintoService {

    private final RecintoRepository recintoRepository;

    //constructor
    public RecintoService(RecintoRepository recintoRepository){
        this.recintoRepository = recintoRepository;
    }
    //crear
    public Recinto crearRecinto(Recinto recinto) {
        return recintoRepository.save(recinto);
    }
    //obtener todo
    public List<Recinto> obtenerTodosLosRecintos(){
        return recintoRepository.findAll();
    }
    public Recinto obtenerRecintoPorId(Long id){
        return recintoRepository.findById(id).orElse(null);
    }

}
