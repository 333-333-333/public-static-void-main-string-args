package com.dci.demo.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * Usuario:
 */

@Entity
@Data
@Getter
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuId;
    private String usuRut;
    private String usuNombre;
    private String usuApellidoPaterno;
    private String usuApellidoMaterno;
    private String usuCorreo;
    @OneToMany
    private List<Reserva> usuReservas;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Rol usuRol;


}
