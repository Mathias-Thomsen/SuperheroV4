package com.example.superherov4.repositories;

import com.example.superherov4.dto.CityDTO;
import com.example.superherov4.dto.CountPowerDTO;
import com.example.superherov4.model.Superhero;

import java.util.ArrayList;
import java.util.List;

public interface IRepository {
    List<Superhero> getSuperheroes();
    Superhero getSuperhero(String superheroName);
    List<CountPowerDTO> getSuperpowerCount();
    CountPowerDTO getCountPowerSuperheroName(String SuperheroName);
    List<CityDTO> getCity();
    CityDTO getCitySuperheroName(String superheroName);

}
