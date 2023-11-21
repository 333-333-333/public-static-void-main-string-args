package com.dci.demo.controller;


import com.dci.demo.domain.Recinto;
import com.dci.demo.service.RecintoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recintos")
public class RecintoController {

    private RecintoService recintoService;

    public RecintoController(RecintoService recintoService){
        this.recintoService = recintoService;
    }

    /*
    todo el controlador debe tener la ruta /recintos
        get all ruta vacía -> /recintos/
        get por id -> /recintos/{id}
        create -> /recintos/ (post en vez de get)
    */

    @PostMapping
    public Recinto crearRecintoControlle(@RequestBody Recinto recinto){
        return recintoService.crearRecinto(recinto);
    }

    @GetMapping("/")
    public List<Recinto> verTodosLosRecintos(){
        return recintoService.obtenerTodosLosRecintos();
    }
    @GetMapping("/{id}")
    public Recinto obtenerRecintoPorId(@PathVariable Long id){
       return recintoService.obtenerRecintoPorId(id);
    }

}
