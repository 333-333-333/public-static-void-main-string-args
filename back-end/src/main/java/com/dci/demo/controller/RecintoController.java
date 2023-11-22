package com.dci.demo.controller;

import com.dci.demo.domain.Recinto;
import com.dci.demo.service.RecintoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recintos/")
@CrossOrigin(origins = "*")
public class RecintoController {


    private RecintoService RecintoService;

    public RecintoController(RecintoService recintoService){
        this.RecintoService = recintoService;
    }

    @PostMapping("")
    public ResponseEntity<?> crearRecinto(@RequestBody Recinto recinto){
        try {
            Recinto recintoCreado = RecintoService.crearRecinto(recinto);
            return ResponseEntity.ok(recintoCreado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> obtenerRecintos(){
        try {
            List<Recinto> recintos = RecintoService.obtenerTodosLosRecintos();
            return ResponseEntity.ok(recintos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> obtenerRecintoPorId(@PathVariable Long id){
        try {
            Recinto recinto = RecintoService.obtenerRecintoPorId(id);
            return ResponseEntity.ok(recinto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}