package com.dci.demo.exception;

public class WrongIdException extends Exception {


    public WrongIdException () {
        super("El valor del Id ingresado no es válido");
    }


}
