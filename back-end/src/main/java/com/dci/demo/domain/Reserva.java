package com.dci.demo.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Reserva {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date resInicio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date resFin;
    @ManyToOne
    private Usuario resUsuario;
    @OneToOne
    private Recinto resRecinto;
    @OneToOne
    private Actividad resActividad;


}
