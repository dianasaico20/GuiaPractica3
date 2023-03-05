package com.ista.web.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.web.app.model.Estudiante;
import com.ista.web.app.repository.EstudianteRepository;
@Service
public class EstudianteServicelmpl extends GenericServicelmpl<Estudiante, String> implements EstudianteService {

    @Autowired
    EstudianteRepository Repository;
    @Override
    public CrudRepository<Estudiante, String> getDao() {
        return Repository;
    }

    @Override
    public Estudiante findByAndNumero(Long numero) {
        return Repository.findByAndNumero(numero);
    }

    @Override
    public Estudiante findByCorreo(String correo) {
        return Repository.findByCorreo(correo);
    }

    @Override
    public List<Estudiante> findAllByOrderByGpa() {
        return Repository.findAllByOrderByGpa();
    }
}
