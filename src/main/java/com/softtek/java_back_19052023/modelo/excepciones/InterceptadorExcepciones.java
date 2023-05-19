package com.softtek.java_back_19052023.modelo.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class InterceptadorExcepciones extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ExcepcionNoEncontrado.class)
    public ResponseEntity<ExcepcionRespuesta> manejarExcepcionNoEncontrado(ExcepcionNoEncontrado ex, WebRequest request ){
        ExcepcionRespuesta excepcion = new ExcepcionRespuesta(HttpStatus.NOT_FOUND,LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(excepcion, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExcepcionRepetido.class)
    public ResponseEntity<ExcepcionRespuesta> manejarExcepcionRepetido(ExcepcionRepetido ex, WebRequest request ){
        ExcepcionRespuesta excepcion = new ExcepcionRespuesta(HttpStatus.CONFLICT,LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(excepcion, HttpStatus.CONFLICT);
    }
}
