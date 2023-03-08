package com.example.superherov4.service;

import com.example.superherov4.model.Superhero;
import com.example.superherov4.repository.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheroService {

    private final SuperheroRepository repository;

    public SuperheroService(SuperheroRepository superhero) {
        this.repository = superhero;
    }


    public List<Superhero> getSuperheros() {
        return repository.getSuperheroes();
    }

    public Superhero getSuperhero(String superheroName) {
        return repository.getSuperhero(superheroName);
    }
}
