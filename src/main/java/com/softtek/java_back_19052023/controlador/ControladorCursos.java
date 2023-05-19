package com.softtek.java_back_19052023.controlador;

import com.softtek.java_back_19052023.controlador.servicio.ICursoServicio;
import com.softtek.java_back_19052023.modelo.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ControladorCursos {

    @Autowired
    ICursoServicio servicio;

    @GetMapping("/cursos")
    public List<Curso> getCursos(){
        return this.servicio.consultarTodos();
    }

    @GetMapping("/cursos/{id}")
    public Curso getCurso(@PathVariable("id") int id_curso){
        return this.servicio.consultarUno(id_curso);
    }

    @PostMapping(value = "/crearCurso", consumes = "application/json", produces = "application/json")
    public Curso addCurso(@RequestBody Curso curs){
        return this.servicio.crear(curs);
    }

    @DeleteMapping("/del/{id}")
    public void delCurso(@PathVariable("id") int id_curso){
        this.servicio.eliminar(id_curso);
    }

    @PutMapping("/cursos")
    public Curso updateCurso(@RequestBody Curso curso){
        return this.servicio.modificar(curso);
    }


}
