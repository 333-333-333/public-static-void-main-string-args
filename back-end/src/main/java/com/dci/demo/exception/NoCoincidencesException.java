package com.dci.demo.exception;

public class NoCoincidencesException extends Exception{


    public NoCoincidencesException() {
        super("No hay coincidencias en el repositorio.");
    }


}
