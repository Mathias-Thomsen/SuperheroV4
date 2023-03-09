package com.example.superherov4.controller;

import com.example.superherov4.dto.CityDTO;
import com.example.superherov4.dto.CountPowerDTO;
import com.example.superherov4.model.Superhero;
import com.example.superherov4.repositories.IRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "kea") //localhost:8080/kea
public class SuperheroController {



    IRepository repository;
    public SuperheroController(ApplicationContext context, @Value("${superhero.repository.impl}") String impl){
        repository = (IRepository) context.getBean(impl);
    }



    @GetMapping(path = "superhero") //localhost:8080/kea/superhero
    public ResponseEntity<List<Superhero>> getSuperheroes() {
        List<Superhero> superheroList = repository.getSuperheroes();
        return new ResponseEntity<List<Superhero>>(superheroList, HttpStatus.OK);

    }

    @GetMapping(path = "superhero/{superheroName}") //localhost:8080/kea/superhero
    public ResponseEntity<Superhero> getSuperhero(@PathVariable String superheroName) {
        Superhero superhero = repository.getSuperhero(superheroName);
        return new ResponseEntity<Superhero>(superhero, HttpStatus.OK);

    }

    @GetMapping(path = "superhero/superpower/count") //localhost:8080/kea/superpower/count
    public ResponseEntity<List<CountPowerDTO>> getSuperpowerCount() {
        List<CountPowerDTO> superpowerCount = repository.getSuperpowerCount();
        return new ResponseEntity<List<CountPowerDTO>>(superpowerCount, HttpStatus.OK);

    }

    @GetMapping(path = "superhero/superpower/count/{superheroName}") //localhost:8080/kea/superhero
    public ResponseEntity<CountPowerDTO> getCountPowerSuperheroName(@PathVariable String superheroName) {
        CountPowerDTO superhero = repository.getCountPowerSuperheroName(superheroName);
        return new ResponseEntity<CountPowerDTO>(superhero, HttpStatus.OK);

    }

    @GetMapping(path = "superhero/city") //localhost:8080/kea/superpower/count
    public ResponseEntity<List<CityDTO>> getCity() {
        List<CityDTO> city = repository.getCity();
        return new ResponseEntity<List<CityDTO>>(city, HttpStatus.OK);

    }

    @GetMapping(path = "superhero/city/{superheroName}") //localhost:8080/kea/superhero
    public ResponseEntity<CityDTO> getCitySuperheroName(@PathVariable String superheroName) {
        CityDTO citySuperheroName = repository.getCitySuperheroName(superheroName);
        return new ResponseEntity<CityDTO>(citySuperheroName, HttpStatus.OK);

    }







}

