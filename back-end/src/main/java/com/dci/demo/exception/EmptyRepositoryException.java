package com.dci.demo.exception;

public class EmptyRepositoryException extends Exception {


    public EmptyRepositoryException() {
        super("No hay datos en el repositorio.");
    }


}
