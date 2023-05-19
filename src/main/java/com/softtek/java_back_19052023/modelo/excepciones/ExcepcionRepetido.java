package com.softtek.java_back_19052023.modelo.excepciones;

public class ExcepcionRepetido extends RuntimeException{
    public ExcepcionRepetido(String mensaje){
        super(mensaje);
    }

    public ExcepcionRepetido(String mensaje, Throwable causa){
        super(mensaje,causa);
    }

    public ExcepcionRepetido(Throwable causa){
        super(causa);
    }

    public ExcepcionRepetido(){
        super();
    }
}
