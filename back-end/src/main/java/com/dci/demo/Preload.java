package com.dci.demo;

import com.dci.demo.domain.*;
import com.dci.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Component
public class Preload implements CommandLineRunner {

    private final RecintoRepository recintoRepository;
    private final TipoRepository tipoRepository;

    private final ActividadRepository actividadRepository;

    private final UsuarioRepository usuarioRepository;

    private final ReservaRepository reservaRepository;

    public Preload (ReservaRepository reservaRepository, RecintoRepository recintoRepository, TipoRepository tipoRepository, ActividadRepository actividadRepository, UsuarioRepository usuarioRepository){
        this.recintoRepository=recintoRepository;
        this.tipoRepository=tipoRepository;
        this.actividadRepository=actividadRepository;
        this.usuarioRepository=usuarioRepository;
        this.reservaRepository=reservaRepository;
    }

    public void run(String... args) throws Exception {
        cargarTodo();
    }

    private void cargarTodo(){
        //Se crean actividades
        Actividad actividad1 = new Actividad();
        actividad1.setActNombre("Futbol");
        actividad1.setActDescripcion("Deporte de equipo jugado entre dos conjuntos de 11 jugadores cada uno y cuatro árbitros que se ocupan de que las normas se cumplan correctamente. Es ampliamente considerado el deporte más popular del mundo, pues lo practican unas 270 millones de personas.");
        actividad1 = actividadRepository.save(actividad1);

        // Actividad 2 - Basketbol
        Actividad actividad2 = new Actividad();
        actividad2.setActNombre("Basketbol");
        actividad2.setActDescripcion("Deporte de equipo en el que dos conjuntos compiten por encestar la pelota en el aro del equipo contrario. Es popular en todo el mundo y se juega tanto a nivel recreativo como profesional.");
        actividad2 = actividadRepository.save(actividad2);

// Actividad 3 - Voleibol
        Actividad actividad3 = new Actividad();
        actividad3.setActNombre("Voleibol");
        actividad3.setActDescripcion("Deporte de equipo en el que dos conjuntos compiten por enviar la pelota al suelo del campo contrario. Se juega en una cancha dividida por una red y es muy popular en todo el mundo.");
        actividad3 = actividadRepository.save(actividad3);

// Actividad 4 - Tenis
        Actividad actividad4 = new Actividad();
        actividad4.setActNombre("Tenis");
        actividad4.setActDescripcion("Deporte de raqueta en el que dos jugadores o dos parejas compiten por golpear la pelota sobre la red y dentro de los límites del campo contrario.");
        actividad4 = actividadRepository.save(actividad4);

// Actividad 5 - Natación
        Actividad actividad5 = new Actividad();
        actividad5.setActNombre("Natación");
        actividad5.setActDescripcion("Deporte acuático en el que los nadadores compiten entre sí en diferentes estilos y distancias. Es una actividad excelente para la salud cardiovascular.");
        actividad5 = actividadRepository.save(actividad5);

// Actividad 6 - Yoga
        Actividad actividad6 = new Actividad();
        actividad6.setActNombre("Yoga");
        actividad6.setActDescripcion("Práctica física, mental y espiritual que combina posturas físicas, ejercicios de respiración y meditación. Contribuye al bienestar físico y emocional.");
        actividad6 = actividadRepository.save(actividad6);

// Actividad 7 - Zumba
        Actividad actividad7 = new Actividad();
        actividad7.setActNombre("Zumba");
        actividad7.setActDescripcion("Actividad física que combina movimientos de baile con ejercicios aeróbicos. Es divertida y efectiva para mejorar la salud cardiovascular.");
        actividad7 = actividadRepository.save(actividad7);

// Actividad 8 - Conversatorio
        Actividad actividad8 = new Actividad();
        actividad8.setActNombre("Conversatorio");
        actividad8.setActDescripcion("Encuentro informal donde las personas discuten y comparten ideas sobre un tema específico. Promueve el intercambio de conocimientos y experiencias.");
        actividad8 = actividadRepository.save(actividad8);

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
        recinto1.setRecPrecio(10000L);
        recinto1.setRecCapacidad(30L);
        recinto1.setRecImagen("https://radiouniversal.cl/wp-content/uploads/2012/06/EstadioLoncoche.jpg");
        recinto1.setRecTipo(tipo1saved);
        recinto1.setRecActividades(Arrays.asList(actividad1, actividad2, actividad3));
        recintoRepository.save(recinto1);

        Recinto recinto2 = new Recinto();
        recinto2.setRecDireccion("Los albinos 25");
        recinto2.setRecTipo(tipo2saved);
        recinto2.setRecNombre("Gimnasio alcalde Rail Neira");
        recinto2.setRecDescripcion("El mejor gimnasio de collipulli, disponible para diversos deportes");
        recinto2.setRecPrecio(20000L);
        recinto2.setRecCapacidad(100L);
        recinto2.setRecImagen("https://radiouniversal.cl/wp-content/uploads/2012/06/EstadioLoncoche.jpg");
        recinto2.setRecActividades(Arrays.asList(actividad2, actividad3));
        recintoRepository.save(recinto2);

// Recinto 3
        Recinto recinto3 = new Recinto();
        recinto3.setRecDescripcion("Cancha de fútbol con iluminación nocturna");
        recinto3.setRecNombre("Estadio Municipal");
        recinto3.setRecDireccion("Avenida Deportiva 500");
        recinto3.setRecPrecio(15000L);
        recinto3.setRecCapacidad(30L);
        recinto3.setRecTipo(tipo1saved);
        recinto3.setRecImagen("https://www.munitucapel.cl/include/images/news/gallery/171/_000000171_3f6ed44826_Tucapel.jpg");
        recinto3.setRecActividades(Arrays.asList(actividad3, actividad4));
        recintoRepository.save(recinto3);

// Recinto 4
        Recinto recinto4 = new Recinto();
        recinto4.setRecDescripcion("Piscina olímpica para natación y competiciones acuáticas");
        recinto4.setRecNombre("Complejo Acuático");
        recinto4.setRecDireccion("Calle del Agua 300");
        recinto4.setRecPrecio(30000L);
        recinto4.setRecCapacidad(20L);
        recinto4.setRecImagen("https://i0.wp.com/www.aqualab.com.pe/wp-content/uploads/2015/05/Piscina-olimpica-San-Borja-03.jpg");
        recinto4.setRecTipo(tipo4saved);
        recinto4.setRecActividades(Arrays.asList(actividad5, actividad6, actividad7, actividad8));
        recintoRepository.save(recinto4);

// Recinto 5
        Recinto recinto5 = new Recinto();
        recinto5.setRecDescripcion("Canchas de tenis");
        recinto5.setRecNombre("Club de Tenis Los Pinos");
        recinto5.setRecDireccion("Avenida de las Raquetas 700");
        recinto5.setRecPrecio(10000L);
        recinto5.setRecCapacidad(8L);
        recinto5.setRecImagen("https://www.tennisworldes.com/imge/1806/medidas-oficiales-de-las-canchas-de-tenis.webp");
        recinto5.setRecTipo(tipo3saved);
        recinto5.setRecActividades(Arrays.asList(actividad4, actividad8));
        recintoRepository.save(recinto5);

        //Crear roles
        Rol rol1 = new Rol();
        rol1.setRolNombre("Administrador");

        Rol rol2 = new Rol();
        rol2.setRolNombre("Usuario");

        Rol rol3 = new Rol();
        rol3.setRolNombre("Encargado");


        //Crear usuarios
        Usuario usuario1 = new Usuario();
        usuario1.setUsuNombre("Rail");
        usuario1.setUsuApellidoPaterno("Neira");
        usuario1.setUsuApellidoMaterno("Marivil");
        usuario1.setUsuRut("12345678-9");
        usuario1.setUsuRol(rol1);
        usuarioRepository.save(usuario1);


        Usuario usuario2 = new Usuario();
        usuario2.setUsuNombre("Juan");
        usuario2.setUsuApellidoPaterno("Perez");
        usuario2.setUsuApellidoMaterno("Gonzalez");
        usuario2.setUsuRut("12345678-9");
        usuario2.setUsuRol(rol2);
        usuarioRepository.save(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.setUsuNombre("Pedro");
        usuario3.setUsuApellidoPaterno("Gonzalez");
        usuario3.setUsuApellidoMaterno("Perez");
        usuario3.setUsuRut("12345678-9");
        usuario3.setUsuRol(rol3);
        usuarioRepository.save(usuario3);




        //Crear reservas
        Reserva reserva1 = new Reserva();
        reserva1.setResInicio(Date.from(Instant.ofEpochSecond(1700753215)));
        reserva1.setResFin(Date.from(Instant.ofEpochSecond(1700760415)));
        reserva1.setResRecinto(recinto1);
        reserva1.setResUsuario(usuario2);
        reserva1.setResActividad(actividad1);
        reservaRepository.save(reserva1);


    }

}
