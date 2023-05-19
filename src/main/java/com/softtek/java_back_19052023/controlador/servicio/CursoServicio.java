package com.softtek.java_back_19052023.controlador.servicio;

import com.softtek.java_back_19052023.modelo.Curso;
import com.softtek.java_back_19052023.modelo.repositorio.ICursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServicio implements ICursoServicio{

    @Autowired
    ICursoRepo repositorio;

    @Override
    public List<Curso> consultarTodos() {
        return repositorio.consultarTodos();
    }

    @Override
    public Curso consultarUno(int id_curso) {
        return repositorio.consultarUno(id_curso);
    }

    @Override
    public Curso crear(Curso curso) {
        return repositorio.crear(curso);
    }

    @Override
    public Curso modificar(Curso curso) {
        return repositorio.modificar(curso);
    }

    @Override
    public void eliminar(int id_curso) {
        repositorio.eliminar(id_curso);
    }
}
