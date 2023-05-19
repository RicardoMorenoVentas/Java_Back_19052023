package com.softtek.java_back_19052023.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curso {
    private int idCurso;
    private String nombre;
    private int duracion;
    private int idProfesor;
}
