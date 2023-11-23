package com.dci.demo.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Getter
@Setter
public class Reserva {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resId;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime resInicio;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime resFin;

    @ManyToOne
    private Usuario resUsuario;
    @ManyToOne
    private Recinto resRecinto;
    @ManyToOne
    private Actividad resActividad;


}
