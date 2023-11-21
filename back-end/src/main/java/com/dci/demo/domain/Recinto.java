package com.dci.demo.domain;

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

    public Long getRecId() {
        return recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public String getRecNombre() {
        return recNombre;
    }

    public void setRecNombre(String recNombre) {
        this.recNombre = recNombre;
    }

    public String getRecDireccion() {
        return recDireccion;
    }

    public void setRecDireccion(String recDireccion) {
        this.recDireccion = recDireccion;
    }

    public String getRecDescripcion() {
        return recDescripcion;
    }

    public void setRecDescripcion(String recDescripcion) {
        this.recDescripcion = recDescripcion;
    }

    public List<Tipo> getRecTipos() {
        return recTipos;
    }

    public void setRecTipos(List<Tipo> recTipos) {
        this.recTipos = recTipos;
    }
}
