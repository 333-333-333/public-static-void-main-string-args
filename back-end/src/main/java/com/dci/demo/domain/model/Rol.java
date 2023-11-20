package com.dci.demo.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Rol {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolId;
    private String rolNombre;
    @OneToMany
    private List<Usuario> rolUsuarios;


}
