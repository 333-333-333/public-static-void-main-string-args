package com.dci.demo.service;

import com.dci.demo.domain.Recinto;
import com.dci.demo.exception.EmptyRepositoryException;
import com.dci.demo.exception.NoCoincidencesException;
import com.dci.demo.exception.WrongIdException;
import com.dci.demo.repository.RecintoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecintoService {


    private final RecintoRepository recintoRepository;

    public RecintoService(RecintoRepository recintoRepository){
        this.recintoRepository = recintoRepository;
    }

    // TODO
    public Recinto crearRecinto(Recinto recinto) {
        return recintoRepository.save(recinto);
    }

    public List<Recinto> obtenerTodosLosRecintos() throws Exception {
        List<Recinto> recintos = recintoRepository.findAll();

        if (recintos.isEmpty()) {
            throw new EmptyRepositoryException();
        }

        return recintoRepository.findAll();
    }

    public Recinto obtenerRecintoPorId(Long id) throws Exception {
        if (id < 0) {
            throw new WrongIdException();
        }

        Optional<Recinto> recinto = recintoRepository.findById(id);

        if (recinto.isEmpty()) {
            throw new NoCoincidencesException();
        }

        return recinto.get();
    }


}
