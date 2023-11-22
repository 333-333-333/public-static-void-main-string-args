package com.dci.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Recinto {


    @Id
    @GeneratedValue
    private Long recId;
    private Long recCapacidad;
    private Long recPrecio;
    private String recNombre;
    private String recDireccion;
    private String recDescripcion;
    private String recImagen;
    @ManyToOne
    @JoinColumn(name = "tip_Id")
    private Tipo recTipo;
    @OneToMany
    private List<Actividad> recActividades;


}
