package com.ista.web.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ista.web.app.model.Estudiante;

public interface EstudianteRepository extends MongoRepository <Estudiante,String> {
    public Estudiante findByAndNumero(Long numero);

    public Estudiante findByCorreo(String correo );

    public List<Estudiante> findAllByOrderByGpa();
}
