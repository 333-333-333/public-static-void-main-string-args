package com.dci.demo.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recinto {


    @Id
    @GeneratedValue
    private Long recId;
    private String recNombre;
    private String recDireccion;
    private String recDescripcion;
    @OneToMany
    private List<Tipo> recTipos;


}
