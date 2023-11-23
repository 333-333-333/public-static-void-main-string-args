package com.dci.demo.service;


import com.dci.demo.domain.Usuario;
import com.dci.demo.exception.EmptyRepositoryException;
import com.dci.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    public UsuarioService (UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    //obtener todos
    public List<Usuario> obtenerTodosLosUsuarios() throws EmptyRepositoryException {
        List<Usuario> usuarios = usuarioRepository.findAll();

        if (usuarios.isEmpty()) {
            throw new EmptyRepositoryException();
        }

        return usuarioRepository.findAll();
    }
    //obtener por id
    public Usuario obtenerUsuarioPorId(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }
    //crear??
    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
