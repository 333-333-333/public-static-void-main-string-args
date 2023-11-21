package com.dci.demo;

import com.dci.demo.domain.Recinto;
import com.dci.demo.domain.Tipo;
import com.dci.demo.repository.RecintoRepository;
import com.dci.demo.repository.TipoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Preload implements CommandLineRunner {

    private final RecintoRepository recintoRepository;
    private final TipoRepository tipoRepository;

    public Preload (RecintoRepository recintoRepository, TipoRepository tipoRepository){
        this.recintoRepository=recintoRepository;
        this.tipoRepository=tipoRepository;
    }

    public void run(String... args) throws Exception {
        cargarTodo();
    }

    private void cargarTodo(){
        //Se crean tipos de recintos manualmente
        Tipo tipo1 = new Tipo();
        tipo1.setTipNombre("Multicancha");
        Tipo tipo1saved = tipoRepository.save(tipo1);

        Tipo tipo2 = new Tipo();
        tipo2.setTipNombre("Gimnasio");
        Tipo tipo2saved = tipoRepository.save(tipo2);

        Tipo tipo3 = new Tipo();
        tipo3.setTipNombre("Anfiteatro");
        Tipo tipo3saved = tipoRepository.save(tipo3);

        Tipo tipo4= new Tipo();
        tipo4.setTipNombre("Piscina");
        Tipo tipo4saved = tipoRepository.save(tipo4);


        Recinto recinto1 = new Recinto();
        recinto1.setRecDescripcion("Multicancha deportiva para realizar multiples deportes");
        recinto1.setRecNombre("Recinto los abedules");
        recinto1.setRecDireccion("Los castaños 1500");
        recinto1.setRecTipo(tipo1saved);
        recintoRepository.save(recinto1);

        Recinto recinto2 = new Recinto();
        recinto2.setRecDireccion("Los albinos 25");
        recinto2.setRecTipo(tipo2saved);
        recinto2.setRecNombre("Gimnasio alcalde Rail Neira");
        recinto2.setRecDescripcion("El mejor gimnasio de collipulli, disponible para diversos deportes");
        recintoRepository.save(recinto2);

// Recinto 3
        Recinto recinto3 = new Recinto();
        recinto3.setRecDescripcion("Cancha de fútbol con iluminación nocturna");
        recinto3.setRecNombre("Estadio Municipal");
        recinto3.setRecDireccion("Avenida Deportiva 500");
        recinto3.setRecTipo(tipo1saved);
        recintoRepository.save(recinto3);

// Recinto 4
        Recinto recinto4 = new Recinto();
        recinto4.setRecDescripcion("Piscina olímpica para natación y competiciones acuáticas");
        recinto4.setRecNombre("Complejo Acuático");
        recinto4.setRecDireccion("Calle del Agua 300");
        recinto4.setRecTipo(tipo4saved);
        recintoRepository.save(recinto4);

// Recinto 5
        Recinto recinto5 = new Recinto();
        recinto5.setRecDescripcion("Canchas de tenis");
        recinto5.setRecNombre("Club de Tenis Los Pinos");
        recinto5.setRecDireccion("Avenida de las Raquetas 700");
        recinto5.setRecTipo(tipo3saved);
        recintoRepository.save(recinto5);
    }

}
