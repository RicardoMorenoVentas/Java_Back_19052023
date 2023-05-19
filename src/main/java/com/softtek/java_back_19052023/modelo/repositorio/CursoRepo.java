package com.softtek.java_back_19052023.modelo.repositorio;

import com.softtek.java_back_19052023.modelo.Curso;
import com.softtek.java_back_19052023.modelo.excepciones.ExcepcionNoEncontrado;
import com.softtek.java_back_19052023.modelo.excepciones.ExcepcionRepetido;
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
    public Curso consultarUno(int id_curso) throws ExcepcionNoEncontrado {
        for (Curso curso: cursos) {
            if (curso.getIdCurso() == id_curso){
                return curso;
            }
        }
        throw new ExcepcionNoEncontrado("No se ha encontrado el curso");
    }

    @Override
    public Curso crear(Curso curso) throws ExcepcionRepetido {
        boolean encontrado = false;
        for (Curso c : cursos){
            if (c.getIdCurso() == curso.getIdCurso()){
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            this.cursos.add(curso);
            return curso;
        }else{
            throw new ExcepcionRepetido("Ya hay un curso con esa ID");
        }
    }

    @Override
    public Curso modificar(Curso curso) throws ExcepcionNoEncontrado {
        for (int i = 0; i < cursos.size(); i++){
            if (cursos.get(i).getIdCurso() == curso.getIdCurso()){
                cursos.set(i,curso);
                return cursos.get(i);
            }
        }
        throw new ExcepcionNoEncontrado("No se ha encontrado el curso");
    }

    @Override
    public void eliminar(int id_curso) throws ExcepcionNoEncontrado{
        for (Curso curso : cursos){
            if (curso.getIdCurso() == id_curso){
                cursos.remove(curso);
            }
        }
        throw new ExcepcionNoEncontrado("No se ha encontrado el curso");
//        Otra solución utilizando métodos de ArrayList
//        this.cursos.removeIf(curso -> curso.getIdCurso() == id_curso);
    }
}
