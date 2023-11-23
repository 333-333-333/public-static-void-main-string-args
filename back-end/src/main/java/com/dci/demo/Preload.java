package com.dci.demo;

import com.dci.demo.domain.*;
import com.dci.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class Preload implements CommandLineRunner {

    private final RecintoRepository recintoRepository;
    private final TipoRepository tipoRepository;

    private final ActividadRepository actividadRepository;

    private final UsuarioRepository usuarioRepository;

    private final ReservaRepository reservaRepository;

    private final RolRepository rolRepository;

    public Preload (ReservaRepository reservaRepository, RecintoRepository recintoRepository, TipoRepository tipoRepository, ActividadRepository actividadRepository, UsuarioRepository usuarioRepository, RolRepository rolRepository){
        this.recintoRepository=recintoRepository;
        this.tipoRepository=tipoRepository;
        this.actividadRepository=actividadRepository;
        this.usuarioRepository=usuarioRepository;
        this.reservaRepository=reservaRepository;
        this.rolRepository=rolRepository;
    }

    public void run(String... args) throws Exception {
        cargarTodo();
    }

    private void cargarTodo(){

        Actividad futbol = new Actividad();
        futbol.setActNombre("Futbol");
        futbol.setActDescripcion("Deporte de equipo jugado entre dos conjuntos de 11 jugadores cada uno y cuatro árbitros que se ocupan de que las normas se cumplan correctamente. Es ampliamente considerado el deporte más popular del mundo, pues lo practican unas 270 millones de personas.");
        futbol = actividadRepository.save(futbol);

        // Actividad 2 - Basketbol
        Actividad basketball = new Actividad();
        basketball.setActNombre("Basketbol");
        basketball.setActDescripcion("Deporte de equipo en el que dos conjuntos compiten por encestar la pelota en el aro del equipo contrario. Es popular en todo el mundo y se juega tanto a nivel recreativo como profesional.");
        basketball = actividadRepository.save(basketball);

// Actividad 3 - Voleibol
        Actividad voleibol = new Actividad();
        voleibol.setActNombre("Voleibol");
        voleibol.setActDescripcion("Deporte de equipo en el que dos conjuntos compiten por enviar la pelota al suelo del campo contrario. Se juega en una cancha dividida por una red y es muy popular en todo el mundo.");
        voleibol = actividadRepository.save(voleibol);

// Actividad 4 - Tenis
        Actividad tenis = new Actividad();
        tenis.setActNombre("Tenis");
        tenis.setActDescripcion("Deporte de raqueta en el que dos jugadores o dos parejas compiten por golpear la pelota sobre la red y dentro de los límites del campo contrario.");
        tenis = actividadRepository.save(tenis);

// Actividad 5 - Natación
        Actividad natacion = new Actividad();
        natacion.setActNombre("Natación");
        natacion.setActDescripcion("Deporte acuático en el que los nadadores compiten entre sí en diferentes estilos y distancias. Es una actividad excelente para la salud cardiovascular.");
        natacion = actividadRepository.save(natacion);

// Actividad 6 - Yoga
        Actividad yoga = new Actividad();
        yoga.setActNombre("Yoga");
        yoga.setActDescripcion("Práctica física, mental y espiritual que combina posturas físicas, ejercicios de respiración y meditación. Contribuye al bienestar físico y emocional.");
        yoga = actividadRepository.save(yoga);

// Actividad 7 - Zumba
        Actividad zumba = new Actividad();
        zumba.setActNombre("Zumba");
        zumba.setActDescripcion("Actividad física que combina movimientos de baile con ejercicios aeróbicos. Es divertida y efectiva para mejorar la salud cardiovascular.");
        zumba = actividadRepository.save(zumba);

// Actividad 8 - Conversatorio
        Actividad conversatorio = new Actividad();
        conversatorio.setActNombre("Conversatorio");
        conversatorio.setActDescripcion("Encuentro informal donde las personas discuten y comparten ideas sobre un tema específico. Promueve el intercambio de conocimientos y experiencias.");
        conversatorio = actividadRepository.save(conversatorio);

        //Se crean tipos de recintos manualmente
        Tipo multicancha = new Tipo();
        multicancha.setTipNombre("Multicancha");
        Tipo tipo1saved = tipoRepository.save(multicancha);

        Tipo gimnasio = new Tipo();
        gimnasio.setTipNombre("Gimnasio");
        Tipo tipo2saved = tipoRepository.save(gimnasio);

        Tipo anfiteatro = new Tipo();
        anfiteatro.setTipNombre("Anfiteatro");
        Tipo tipo3saved = tipoRepository.save(anfiteatro);

        Tipo piscina= new Tipo();
        piscina.setTipNombre("Piscina");
        Tipo tipo4saved = tipoRepository.save(piscina);


        Recinto multicancha_recinto = new Recinto();
        multicancha_recinto.setRecDescripcion("Multicancha deportiva para realizar multiples deportes");
        multicancha_recinto.setRecNombre("Recinto los abedules");
        multicancha_recinto.setRecDireccion("Los castaños 1500");
        multicancha_recinto.setRecPrecio(10000L);
        multicancha_recinto.setRecCapacidad(30L);
        multicancha_recinto.setRecImagen("https://construccionmulticanchas.cl/wp-content/uploads/2019/09/2.jpg");
        multicancha_recinto.setRecTipo(tipo1saved);
        multicancha_recinto.setRecActividades(Arrays.asList(futbol, basketball, voleibol));
        recintoRepository.save(multicancha_recinto);

        Recinto gimnasio_recinto = new Recinto();
        gimnasio_recinto.setRecDireccion("Los albinos 25");
        gimnasio_recinto.setRecTipo(tipo2saved);
        gimnasio_recinto.setRecNombre("Gimnasio alcalde Rail Neira");
        gimnasio_recinto.setRecDescripcion("El mejor gimnasio de collipulli, disponible para diversos deportes");
        gimnasio_recinto.setRecPrecio(20000L);
        gimnasio_recinto.setRecCapacidad(100L);
        gimnasio_recinto.setRecImagen("https://radiouniversal.cl/wp-content/uploads/2012/06/EstadioLoncoche.jpg");
        gimnasio_recinto.setRecActividades(Arrays.asList(basketball, voleibol));
        recintoRepository.save(gimnasio_recinto);

// Recinto 3
        Recinto cancha = new Recinto();
        cancha.setRecDescripcion("Cancha de fútbol con iluminación nocturna");
        cancha.setRecNombre("Estadio Municipal");
        cancha.setRecDireccion("Avenida Deportiva 500");
        cancha.setRecPrecio(15000L);
        cancha.setRecCapacidad(30L);
        cancha.setRecTipo(tipo1saved);
        cancha.setRecImagen("https://www.munitucapel.cl/include/images/news/gallery/171/_000000171_3f6ed44826_Tucapel.jpg");
        cancha.setRecActividades(Arrays.asList(voleibol, tenis, futbol));
        recintoRepository.save(cancha);

// Recinto 4
        Recinto piscina_recinto = new Recinto();
        piscina_recinto.setRecDescripcion("Piscina olímpica para natación y competiciones acuáticas");
        piscina_recinto.setRecNombre("Complejo Acuático");
        piscina_recinto.setRecDireccion("Calle del Agua 300");
        piscina_recinto.setRecPrecio(30000L);
        piscina_recinto.setRecCapacidad(20L);
        piscina_recinto.setRecImagen("https://i0.wp.com/www.aqualab.com.pe/wp-content/uploads/2015/05/Piscina-olimpica-San-Borja-03.jpg");
        piscina_recinto.setRecTipo(tipo4saved);
        piscina_recinto.setRecActividades(Arrays.asList(natacion, yoga, zumba));
        recintoRepository.save(piscina_recinto);

// Recinto 5
        Recinto cancha_tenis = new Recinto();
        cancha_tenis.setRecDescripcion("Canchas de tenis");
        cancha_tenis.setRecNombre("Club de Tenis Los Pinos");
        cancha_tenis.setRecDireccion("Avenida de las Raquetas 700");
        cancha_tenis.setRecPrecio(10000L);
        cancha_tenis.setRecCapacidad(8L);
        cancha_tenis.setRecImagen("https://www.tennisworldes.com/imge/1806/medidas-oficiales-de-las-canchas-de-tenis.webp");
        cancha_tenis.setRecTipo(tipo3saved);
        cancha_tenis.setRecActividades(Arrays.asList(tenis, conversatorio));
        recintoRepository.save(cancha_tenis);

        //Crear roles
        Rol admin = new Rol();
        admin.setRolNombre("Administrador");
        admin = rolRepository.save(admin);

        Rol usuario = new Rol();
        usuario.setRolNombre("Usuario");
        usuario = rolRepository.save(usuario);

        Rol encargado = new Rol();
        encargado.setRolNombre("Encargado");
        encargado = rolRepository.save(encargado);


        //Crear usuarios
        Usuario usuario1 = new Usuario();
        usuario1.setUsuNombre("Rail");
        usuario1.setUsuApellidoPaterno("Neira");
        usuario1.setUsuApellidoMaterno("Marivil");
        usuario1.setUsuRut("12345678-9");
        usuario1.setUsuCorreo("rail.neira@collipulli.cl");
        usuario1.setUsuRol(admin);
        usuarioRepository.save(usuario1);


        Usuario usuario2 = new Usuario();
        usuario2.setUsuNombre("Juan");
        usuario2.setUsuApellidoPaterno("Perez");
        usuario2.setUsuApellidoMaterno("Gonzalez");
        usuario2.setUsuRut("12345678-9");
        usuario2.setUsuRol(usuario);
        usuario2.setUsuCorreo("JuanPerez12345@gmail.com");
        usuarioRepository.save(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.setUsuNombre("Pedro");
        usuario3.setUsuApellidoPaterno("Gonzalez");
        usuario3.setUsuApellidoMaterno("Perez");
        usuario3.setUsuRut("12345678-9");
        usuario3.setUsuCorreo("pedro.gonzalez@collipulli.cl");
        usuario3.setUsuRol(encargado);
        usuarioRepository.save(usuario3);


        Usuario usuario4 = new Usuario();
        usuario4.setUsuRol(admin);
        usuario4.setUsuCorreo("ninoska.diaz@collipulli.cl");
        usuario4.setUsuNombre("Ninoska");
        usuario4.setUsuApellidoPaterno("Diaz");
        usuario4.setUsuApellidoMaterno("Lopez");
        usuario4.setUsuRut("21896359-4");
        usuarioRepository.save(usuario4);

        Usuario usuario5 = new Usuario();
        usuario5.setUsuNombre("Tomás");
        usuario5.setUsuApellidoPaterno("Baeza");
        usuario5.setUsuApellidoMaterno("Núñez");
        usuario5.setUsuRut("20698711-3");
        usuario5.setUsuCorreo("tomas.baeza@collipulli.cl");
        usuario5.setUsuRol(encargado);
        usuarioRepository.save(usuario5);

        Usuario usuario6 = new Usuario();
        usuario6.setUsuNombre("Jorge");
        usuario6.setUsuApellidoPaterno("Gonzalez");
        usuario6.setUsuApellidoMaterno("Perez");
        usuario6.setUsuRut("12345678-9");
        usuario6.setUsuCorreo("mail@gmail.cl");
        usuario6.setUsuRol(usuario);
        usuarioRepository.save(usuario6);

        Usuario usuario99 = new Usuario();
        usuario1.setUsuNombre("Invitado");
        usuario1.setUsuApellidoPaterno("Invitado");
        usuario1.setUsuApellidoMaterno("Invitado");
        usuario1.setUsuRut("sin rut");
        usuario1.setUsuCorreo("sin correo");
        usuario1.setUsuRol(usuario);
        usuarioRepository.save(usuario99);

       //Crear reservas
        Reserva reserva1 = new Reserva();
        reserva1.setResInicio(LocalDateTime.of(2023,11,23,10,0,0));
        reserva1.setResFin(LocalDateTime.of(2023,11,23,11,0,0));
        reserva1.setResRecinto(multicancha_recinto);
        reserva1.setResUsuario(usuario2);
        reserva1.setResActividad(futbol);
        reservaRepository.save(reserva1);


        Reserva reserva2 = new Reserva();
        reserva2.setResInicio(LocalDateTime.of(2023,11,23,11,0,0));
        reserva2.setResFin(LocalDateTime.of(2023,11,23,12,0,0));
        reserva2.setResRecinto(multicancha_recinto);
        reserva2.setResUsuario(usuario2);
        reserva2.setResActividad(futbol);
        reservaRepository.save(reserva2);

        Reserva reserva3 = new Reserva();
        reserva3.setResInicio(LocalDateTime.of(2023,11,23,12,0,0));
        reserva3.setResFin(LocalDateTime.of(2023,11,23,13,0,0));
        reserva3.setResRecinto(piscina_recinto);
        reserva3.setResUsuario(usuario6);
        reserva3.setResActividad(natacion);
        reservaRepository.save(reserva3);

        Reserva reserva4 = new Reserva();
        reserva4.setResInicio(LocalDateTime.of(2023,11,24,13,0,0));
        reserva4.setResFin(LocalDateTime.of(2023,11,24,14,0,0));
        reserva4.setResRecinto(piscina_recinto);
        reserva4.setResUsuario(usuario6);
        reserva4.setResActividad(natacion);
        reservaRepository.save(reserva4);

        Reserva reserva5 = new Reserva();
        reserva5.setResInicio(LocalDateTime.of(2023,11,24,14,0,0));
        reserva5.setResFin(LocalDateTime.of(2023,11,24,15,0,0));
        reserva5.setResRecinto(cancha_tenis);
        reserva5.setResUsuario(usuario6);
        reserva5.setResActividad(tenis);
        reservaRepository.save(reserva5);

        Reserva reserva6 = new Reserva();
        reserva6.setResInicio(LocalDateTime.of(2023,11,24,15,0,0));
        reserva6.setResFin(LocalDateTime.of(2023,11,24,16,0,0));
        reserva6.setResRecinto(cancha);
        reserva6.setResUsuario(usuario6);
        reserva6.setResActividad(futbol);
        reservaRepository.save(reserva6);

        Reserva reserva7 = new Reserva();
        reserva7.setResInicio(LocalDateTime.of(2023,11,24,16,0,0));
        reserva7.setResFin(LocalDateTime.of(2023,11,24,17,0,0));
        reserva7.setResRecinto(cancha);
        reserva7.setResUsuario(usuario6);
        reserva7.setResActividad(futbol);
        reservaRepository.save(reserva7);

        Reserva reserva8 = new Reserva();
        reserva8.setResInicio(LocalDateTime.of(2023,11,24,8,0,0));
        reserva8.setResFin(LocalDateTime.of(2023,11,24,9,0,0));
        reserva8.setResRecinto(multicancha_recinto);
        reserva8.setResUsuario(usuario6);
        reserva8.setResActividad(futbol);
        reservaRepository.save(reserva8);

        Reserva reserva9 = new Reserva();
        reserva9.setResInicio(LocalDateTime.of(2023,11,24,9,0,0));
        reserva9.setResFin(LocalDateTime.of(2023,11,24,10,0,0));
        reserva9.setResRecinto(multicancha_recinto);
        reserva9.setResUsuario(usuario6);
        reserva9.setResActividad(futbol);
        reservaRepository.save(reserva9);

        Reserva reserva10 = new Reserva();
        reserva10.setResInicio(LocalDateTime.of(2023,11,24,12,0,0));
        reserva10.setResFin(LocalDateTime.of(2023,11,24,13,0,0));
        reserva10.setResRecinto(multicancha_recinto);
        reserva10.setResUsuario(usuario6);
        reserva10.setResActividad(futbol);
        reservaRepository.save(reserva10);

        Reserva reserva11 = new Reserva();
        reserva11.setResInicio(LocalDateTime.of(2023,11,24,13,0,0));
        reserva11.setResFin(LocalDateTime.of(2023,11,24,14,0,0));
        reserva11.setResRecinto(multicancha_recinto);
        reserva11.setResUsuario(usuario6);
        reserva11.setResActividad(futbol);
        reservaRepository.save(reserva11);

        Reserva reserva12 = new Reserva();
        reserva12.setResInicio(LocalDateTime.of(2023,11,24,14,0,0));
        reserva12.setResFin(LocalDateTime.of(2023,11,24,15,0,0));
        reserva12.setResRecinto(multicancha_recinto);
        reserva12.setResUsuario(usuario6);
        reserva12.setResActividad(futbol);
        reservaRepository.save(reserva12);

        Reserva reserva13 = new Reserva();
        reserva13.setResInicio(LocalDateTime.of(2023,11,24,15,0,0));
        reserva13.setResFin(LocalDateTime.of(2023,11,24,16,0,0));
        reserva13.setResRecinto(multicancha_recinto);
        reserva13.setResUsuario(usuario6);
        reserva13.setResActividad(futbol);
        reservaRepository.save(reserva13);

        Reserva reserva14 = new Reserva();
        reserva14.setResInicio(LocalDateTime.of(2023,11,24,16,0,0));
        reserva14.setResFin(LocalDateTime.of(2023,11,24,17,0,0));
        reserva14.setResRecinto(multicancha_recinto);
        reserva14.setResUsuario(usuario6);
        reserva14.setResActividad(futbol);
        reservaRepository.save(reserva14);

        Reserva reserva15 = new Reserva();
        reserva15.setResInicio(LocalDateTime.of(2023,11,24,17,0,0));
        reserva15.setResFin(LocalDateTime.of(2023,11,24,18,0,0));
        reserva15.setResRecinto(multicancha_recinto);
        reserva15.setResUsuario(usuario6);
        reserva15.setResActividad(futbol);
        reservaRepository.save(reserva15);
    }

}
