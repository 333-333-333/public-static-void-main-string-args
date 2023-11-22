package com.dci.demo.util;

import com.dci.demo.domain.*;

public class Validador {

    public static Boolean validarReserva(Reserva reserva) {
        if (reserva == null) {
            return false;
        }
        if (reserva.getResInicio() == null || reserva.getResFin() == null) {
            return false;
        }
        if (!validarUsuario(reserva.getResUsuario())) {
            return false;
        }
        if (!validarRecinto(reserva.getResRecinto())) {
            return false;
        }
        if (!validarActividad(reserva.getResActividad())) {
            return false;
        }
        return true;
    }

    public static Boolean validarUsuario(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        if (usuario.getUsuNombre() == null || usuario.getUsuNombre().isEmpty()) {
            return false;
        }
        if (usuario.getUsuApellidoPaterno() == null || usuario.getUsuApellidoPaterno().isEmpty()) {
            return false;
        }
        if (usuario.getUsuApellidoMaterno() == null || usuario.getUsuApellidoMaterno().isEmpty()) {
            return false;
        }
        if (!validarRol(usuario.getUsuRol())) {return false;
        }
        return true;
    }

    public static Boolean validarRol(Rol rol) {
        if (rol == null) {
            return false;
        }
        if (rol.getRolNombre() == null ||
                rol.getRolNombre().isEmpty()) {
            return false;
        }
        return true;
    }

    public static Boolean validarActividad(Actividad actividad) {
        if (actividad == null) {
            return false;
        }
        if (actividad.getActNombre() == null || actividad.getActNombre().isEmpty()) {
            return false;
        }
        if (actividad.getActDescripcion() == null || actividad.getActDescripcion().isEmpty()) {
            return false;
        }
        return true;
    }

    public static Boolean validarRecinto(Recinto recinto) {
        if (recinto == null) {
            return false;
        }
        if (recinto.getRecNombre() == null || recinto.getRecNombre().isEmpty()) {
            return false;
        }
        if (recinto.getRecDescripcion() == null || recinto.getRecDescripcion().isEmpty()) {
            return false;
        }
        if (recinto.getRecDireccion() == null || recinto.getRecDireccion().isEmpty()) {
            return false;
        }
        if (recinto.getRecCapacidad() == null || recinto.getRecCapacidad() <= 0) {
            return false;
        }
        if (recinto.getRecPrecio() == null || recinto.getRecPrecio() <= 0) {
            return false;
        }
        if (!validarTipo(recinto.getRecTipo())) {
            return false;
        }
        return true;
    }

    public static Boolean validarTipo(Tipo tipo) {
        if (tipo == null) {
            return false;
        }
        if (tipo.getTipNombre() == null || tipo.getTipNombre().isEmpty()) {
            return false;
        }
        return true;
    }


}
