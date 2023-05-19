package com.softtek.java_back_19052023.modelo.repositorio;

import com.softtek.java_back_19052023.modelo.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepo implements ICursoRepo {

    private ArrayList<Curso> cursos = new ArrayList<>();

    @Override
    public List<Curso> consultarTodos() {
        return this.cursos;
    }

    @Override
    public Curso consultarUno(int id_curso) {
        for (Curso curso: cursos) {
            if (curso.getIdCurso() == id_curso){
                return curso;
            }
        }
        return null;
    }

    @Override
    public Curso crear(Curso curso) {
        boolean encontrado = false;
        for (Curso c : cursos){
            if (c.getIdCurso() == curso.getIdCurso()){
                encontrado = true;
                break;
            }
        }
        if (!encontrado) this.cursos.add(curso);
        return curso;
    }

    @Override
    public Curso modificar(Curso curso) {
        for (int i = 0; i < cursos.size(); i++){
            if (cursos.get(i).getIdCurso() == curso.getIdCurso()){
                cursos.set(i,curso);
                return cursos.get(i);
            }
        }
        return null;
    }

    @Override
    public void eliminar(int id_curso) {
        for (Curso curso : cursos){
            if (curso.getIdCurso() == id_curso){
                cursos.remove(curso);
                break;
            }
        }
    }
}
