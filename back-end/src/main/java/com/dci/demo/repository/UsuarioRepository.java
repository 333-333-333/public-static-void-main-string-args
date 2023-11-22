package com.dci.demo.repository;

import com.dci.demo.domain.Tipo;
import com.dci.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
