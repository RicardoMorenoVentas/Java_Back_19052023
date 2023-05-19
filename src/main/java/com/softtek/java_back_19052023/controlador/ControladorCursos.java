package com.softtek.java_back_19052023.controlador;

import com.softtek.java_back_19052023.controlador.servicio.ICursoServicio;
import com.softtek.java_back_19052023.modelo.Curso;
import com.softtek.java_back_19052023.modelo.excepciones.ExcepcionNoEncontrado;
import com.softtek.java_back_19052023.modelo.excepciones.ExcepcionRepetido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ControladorCursos {

    @Autowired
    ICursoServicio servicio;

    @GetMapping("/cursos")
    public ResponseEntity<List<Curso>> getCursos(){
        return new ResponseEntity<>(this.servicio.consultarTodos(),HttpStatus.OK);
    }

    @GetMapping("/cursos/{id}")
    public ResponseEntity<Curso> getCurso(@PathVariable("id") int id_curso) throws ExcepcionNoEncontrado {
        Curso out = this.servicio.consultarUno(id_curso);
        return new ResponseEntity<>(out, HttpStatus.OK);
    }

    @PostMapping(value = "/crearCurso", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Curso> addCurso(@RequestBody Curso curs) throws ExcepcionRepetido {
        Curso out = this.servicio.crear(curs);
        return new ResponseEntity<>(out,HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public void delCurso(@PathVariable("id") int id_curso) throws ExcepcionNoEncontrado{
        this.servicio.eliminar(id_curso);
    }

    @PutMapping("/cursos")
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso) throws ExcepcionNoEncontrado{
        Curso out = this.servicio.modificar(curso);
        return new ResponseEntity<>(out,HttpStatus.OK);
    }


}
