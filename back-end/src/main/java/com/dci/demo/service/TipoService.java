package com.dci.demo.service;

import com.dci.demo.domain.Tipo;
import com.dci.demo.repository.TipoRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoService {

    private final TipoRepository tipoRepository;

    public TipoService(TipoRepository tipoRepository){
        this.tipoRepository=tipoRepository;
    }

    public Tipo crearTipo(Tipo tipo){
        return tipoRepository.save(tipo);
    }
}
