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
    private String recNombre;
    private String recDireccion;
    private String recDescripcion;
    @ManyToOne
    @JoinColumn(name = "tip_Id")
    private Tipo recTipo;


}
