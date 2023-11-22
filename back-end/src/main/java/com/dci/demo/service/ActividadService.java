package com.dci.demo.service;

import com.dci.demo.domain.Actividad;
import com.dci.demo.exception.EmptyRepositoryException;
import com.dci.demo.exception.WrongIdException;
import com.dci.demo.repository.ActividadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadService {


    private ActividadRepository ActividadRepository;

    public ActividadService(ActividadRepository ActividadRepository) {
        this.ActividadRepository = ActividadRepository;
    }

    public List<Actividad> obtenerActividades() {
        return ActividadRepository.findAll();
    }

    public List<Actividad> obtenerActividadesPorRecinto(Long recId) throws Exception {
        try {
            if (recId == null || recId < 0) {
                throw new WrongIdException();
            }

            List<Actividad> actividades = ActividadRepository.findActividadesByRecinto(recId);

            if (actividades.isEmpty()) {
                throw new EmptyRepositoryException();
            }

            return actividades;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}