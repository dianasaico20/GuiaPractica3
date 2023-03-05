package com.ista.web.app.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "estudiante")
public class Estudiante {
    @Id
    private String id;
    private String nombre;
    private Long numero;
    private String correo;
    private List<String> cursoLista;
    private double gpa;
    

}
