package com.dci.demo.controller;

import com.dci.demo.domain.Usuario;
import com.dci.demo.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios/")
public class UsuarioController {
    private UsuarioService usuarioService;
    public UsuarioController (UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }

    @PostMapping("crearUsuarios")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
        try {
            Usuario usuarioCreado = usuarioService.crearUsuario(usuario);
            return ResponseEntity.ok(usuarioCreado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> obtenerUsuarios(){
        try {
            List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable Long id){
        try {
            Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

