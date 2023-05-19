package com.softtek.java_back_19052023.modelo.excepciones;

public class ExcepcionNoEncontrado extends RuntimeException{
    public ExcepcionNoEncontrado(String mensaje){
        super(mensaje);
    }

    public ExcepcionNoEncontrado(String mensaje, Throwable causa){
        super(mensaje,causa);
    }

    public ExcepcionNoEncontrado(Throwable causa){
        super(causa);
    }

    public ExcepcionNoEncontrado(){
        super();
    }
}
