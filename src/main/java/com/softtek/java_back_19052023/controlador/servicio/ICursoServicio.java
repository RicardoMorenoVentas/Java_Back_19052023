package com.softtek.java_back_19052023.controlador.servicio;

import com.softtek.java_back_19052023.modelo.Curso;

import java.util.List;

public interface ICursoServicio {
    public List<Curso> consultarTodos();
    public Curso consultarUno(int id_curso);
    public Curso crear(Curso curso);
    public Curso modificar(Curso curso);
    public void eliminar(int id_curso);
}
