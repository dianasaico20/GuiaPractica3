package com.ista.web.app.service;

import java.util.List;

import com.ista.web.app.model.Estudiante;

public interface EstudianteService  extends GenericService<Estudiante, String>{

    public Estudiante findByAndNumero(Long numero);

    public Estudiante findByCorreo(String correo );

    public List<Estudiante> findAllByOrderByGpa();


}