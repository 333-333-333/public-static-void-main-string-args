package com.dci.demo.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Tipo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipId;
    private String tipNombre;

    public String getTipNombre() {
        return tipNombre;
    }

    public void setTipNombre(String tipNombre) {
        this.tipNombre = tipNombre;
    }
}
