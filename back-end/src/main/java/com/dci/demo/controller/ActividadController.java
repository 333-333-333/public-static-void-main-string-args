package com.dci.demo.controller;

import com.dci.demo.domain.Actividad;
import com.dci.demo.domain.Recinto;
import com.dci.demo.exception.WrongIdException;
import com.dci.demo.repository.ActividadRepository;
import com.dci.demo.service.ActividadService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/actividades/")
@CrossOrigin(origins = "*")
public class ActividadController {
    private ActividadService actividadService;


    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @GetMapping("{recId}")
    public ResponseEntity<?> obtenerActividadesPorRecinto(Long recId){
        try {
            List<Actividad> actividades = actividadService.obtenerActividadesPorRecinto(recId);
            return ResponseEntity.ok(actividades);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> obtenerTodasLasActividades(){
        try {
            List<Actividad> actividades = actividadService.obtenerActividades();
            return ResponseEntity.ok(actividades);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}