package com.ista.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.web.app.model.Estudiante;
import com.ista.web.app.service.EstudianteService;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {
    @Autowired
    EstudianteService Service;
    @GetMapping("/listar")
    public ResponseEntity<List<Estudiante>> listar() {
        return new ResponseEntity<>(Service.findByAll(),
                HttpStatus.OK); }

    @GetMapping("/listargpa")
    public ResponseEntity<List<Estudiante>> listargpa() {
        return new ResponseEntity<>(Service.findAllByOrderByGpa(),
                HttpStatus.OK); }
    
    @GetMapping("/listar/{correo}")
    public ResponseEntity<Estudiante> findByEmail(@PathVariable("email") String correo) {
           return new ResponseEntity<>(Service.findByCorreo(correo), HttpStatus.OK); }

    @GetMapping("/listar/{num}")
    public ResponseEntity<Estudiante> buscarnum(@PathVariable("num") Long num) {
        return new ResponseEntity<>(Service.findByAndNumero(num),HttpStatus.OK);   }
    
    @PostMapping("/crear")
    public ResponseEntity<Estudiante> crear(
            @RequestBody Estudiante p) {
        return new ResponseEntity<>(Service.save(p),
                HttpStatus.CREATED); }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable String id, @RequestBody Estudiante p) {
        Estudiante ENcontrada = Service.findById(id);
        if (ENcontrada==null) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }else { ENcontrada.setNombre(p.getNombre());
            ENcontrada.setNumero(p.getNumero());
            ENcontrada.setCursoLista(p.getCursoLista());
            ENcontrada.setGpa(p.getGpa());

            return new ResponseEntity<>(Service.save(ENcontrada),HttpStatus.OK);   }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Estudiante> eliminar(@PathVariable String id) {
      Service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);}
}
