package com.dci.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Actividad {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actId;
    private String actNombre;
    private String actDescripcion;


}
