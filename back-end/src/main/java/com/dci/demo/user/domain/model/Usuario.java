package com.dci.demo.user.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Usuario:
 */

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuId;
    private String usuRut;
    private String usuNombre;
    private String usuApellidoPaterno;
    private String usuApellidoMaterno;


}
