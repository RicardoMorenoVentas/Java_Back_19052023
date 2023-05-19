package com.softtek.java_back_19052023.modelo.excepciones;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
public class ExcepcionRespuesta {

    @JsonProperty
    private HttpStatus status;
    @JsonProperty
    private LocalDateTime fecha;
    @JsonProperty
    private String mensaje;
    @JsonProperty
    private String descipcion;
}
