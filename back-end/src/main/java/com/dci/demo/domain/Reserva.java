package com.dci.demo.domain;


import jakarta.persistence.*;

import java.util.Date;

@Entity

public class Reserva {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resId;
    private Date resInicio;
    private Date resFin;
    @ManyToOne
    private Usuario resUsuario;
    @OneToOne
    @JoinColumn(name = "rec_Id")
    private Recinto resRecinto;
    @OneToOne
    @JoinColumn(name = "act_Id")
    private Actividad resActividad;


}
