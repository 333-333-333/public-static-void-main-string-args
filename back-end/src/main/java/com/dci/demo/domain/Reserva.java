package com.dci.demo.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Getter
@Setter
public class Reserva {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resId;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date resInicio;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date resFin;
    @ManyToOne
    private Usuario resUsuario;
    @OneToOne
    private Recinto resRecinto;
    @OneToOne
    private Actividad resActividad;


}
