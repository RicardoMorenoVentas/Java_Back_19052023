package com.softtek.java_back_19052023.controlador;

import com.softtek.java_back_19052023.controlador.servicio.ICursoServicio;
import com.softtek.java_back_19052023.modelo.Curso;
import com.softtek.java_back_19052023.modelo.excepciones.ExcepcionNoEncontrado;
import com.softtek.java_back_19052023.modelo.excepciones.ExcepcionRepetido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/")
public class ControladorCursos {

    @Autowired
    ICursoServicio servicio;

    /**
     * Get de cursos tipo 3 de madurez de Richardson
     * @return Arraylist de los modelos
     */
    @GetMapping("/cursos")
    public ArrayList<EntityModel> getCursos(){
        ArrayList<Curso> cursos = (ArrayList<Curso>) this.servicio.consultarTodos();
        ArrayList<EntityModel> modelos = new ArrayList<>();
        for (Curso curso : cursos){
            WebMvcLinkBuilder linked = linkTo(methodOn(this.getClass()).consultarUno(curso.getIdCurso()));
            modelos.add(EntityModel.of(curso).add(linked.withRel("curso-link")));
        }
        return modelos;
    }

    /*@GetMapping("/cursos")
    public ResponseEntity<List<Curso>> getCursos(){
        return new ResponseEntity<>(this.servicio.consultarTodos(),HttpStatus.OK);
    }*/

    /**
     * Get de tipo 2 en madurez de Richardson
     * @param id_curso
     * @return
     * @throws ExcepcionNoEncontrado
     */
    /*@GetMapping("/cursos/{id}")
    public ResponseEntity<Curso> getCurso(@PathVariable("id") int id_curso) throws ExcepcionNoEncontrado {
        Curso out = this.servicio.consultarUno(id_curso);
        return new ResponseEntity<>(out, HttpStatus.OK);
    }*/

    /**
     * Get de tipo 3 en madurez de Richardson
     * @param id ID del curso
     * @return EntityModel con el objeto y su link. Richardson tipo 3
     * @throws ExcepcionNoEncontrado Excepcion propia si no encuentra el curso
     */
    @GetMapping("/cursos/{id}")
    public EntityModel<Curso> consultarUno(@PathVariable("id") int id) throws ExcepcionNoEncontrado{
        Curso out = servicio.consultarUno(id);
        WebMvcLinkBuilder linked = linkTo(methodOn(this.getClass()).consultarUno(id));
        return EntityModel.of(out).add(linked.withRel("curso-link"));
    }

    /**
     * Post de tipo 2 en madurez de Richardson
     * @param curs
     * @return
     * @throws ExcepcionRepetido
     */
    /*@PostMapping(value = "/crearCurso", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Curso> addCurso(@RequestBody Curso curs) throws ExcepcionRepetido {
        Curso out = this.servicio.crear(curs);
        return new ResponseEntity<>(out,HttpStatus.OK);
    }*/

    /**
     * Post de Tipo 3 en madurez de Richardson
     * @param curs
     * @return
     * @throws ExcepcionRepetido
     */
    @PostMapping(value = "/crearCurso", consumes = "application/json", produces = "application/json")
    public EntityModel<Curso> addCurso(@RequestBody Curso curs) throws ExcepcionRepetido {
//    public ResponseEntity<Void> addCurso(@RequestBody Curso curs) throws ExcepcionRepetido {
        Curso out = this.servicio.crear(curs);
//        Así es como lo tenía gabriela, no me gusta como es ya que no devuelve la URL del nuevo curso.
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/cursos/{id}").buildAndExpand((out.getIdCurso())).toUri();
//        return ResponseEntity.created(location).build();
        WebMvcLinkBuilder linked = linkTo(methodOn(this.getClass()).consultarUno(out.getIdCurso()));
        return EntityModel.of(out).add(linked.withRel("curso-link"));
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> delCurso(@PathVariable("id") int id_curso) throws ExcepcionNoEncontrado{
        this.servicio.eliminar(id_curso);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*@PutMapping("/cursos")
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso) throws ExcepcionNoEncontrado{
        Curso out = this.servicio.modificar(curso);
        return new ResponseEntity<>(out,HttpStatus.OK);
    }*/

    @PutMapping("/cursos")
    public EntityModel<Curso> updateCurso(@RequestBody Curso curso) throws ExcepcionNoEncontrado{
        Curso out = this.servicio.modificar(curso);
        WebMvcLinkBuilder linked = linkTo(methodOn(this.getClass()).consultarUno(curso.getIdCurso()));
        return EntityModel.of(out).add(linked.withRel("curso-link"));
    }


}
