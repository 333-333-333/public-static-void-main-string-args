package com.dci.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Rol {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolId;
    private String rolNombre;
    @OneToMany
    private List<Usuario> rolUsuarios;


}
