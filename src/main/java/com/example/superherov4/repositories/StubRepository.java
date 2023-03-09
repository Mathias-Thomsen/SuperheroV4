package com.example.superherov4.repositories;

import com.example.superherov4.dto.CityDTO;
import com.example.superherov4.dto.CountPowerDTO;
import com.example.superherov4.dto.SuperpowerDTO;
import com.example.superherov4.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("stubRepository")
public class StubRepository implements IRepository {

    //TEST DATA
    private Superhero superhero1 = new Superhero(1, "Superman", "Clark Kent",  1938);
    private Superhero superhero2 = new Superhero(2, "Batman",  "Bruce Wayne",  1939);
    private Superhero superhero3 = new Superhero(3, "The Flash", "Barry Allen", 1956);
    private Superhero superhero4 = new Superhero(4, "Green Arrow",  "Oliver Queen",  1941);
    private Superhero superhero5 = new Superhero(5, "Supergirl",  "Kara Danvers", 1959);

    private CityDTO city1 = new CityDTO("Superman", "Metropolis");
    private CityDTO city2 = new CityDTO("Batman", "Gotham City");
    private CityDTO city3 = new CityDTO("The Flash", "Central City");
    private CityDTO city4 = new CityDTO("Green Arrow", "Star City");
    private CityDTO city5 = new CityDTO("Supergirl", "National City");

    private SuperpowerDTO superpower1 = new SuperpowerDTO("Flight", 1);
    private SuperpowerDTO superpower2 = new SuperpowerDTO("Super Strength", 2);
    private SuperpowerDTO superpower3 = new SuperpowerDTO("Super Speed", 3);
    private SuperpowerDTO superpower4 = new SuperpowerDTO("Intelligence", 4);
    private SuperpowerDTO superpower5 = new SuperpowerDTO("Wealth", 5);
    private SuperpowerDTO superpower6 = new SuperpowerDTO("Archery", 6);

    private CountPowerDTO sumPower1 = new CountPowerDTO("Superman", 1);
    private CountPowerDTO sumPower2 = new CountPowerDTO("Superman", 2);
    private CountPowerDTO sumPower3 = new CountPowerDTO("Batman", 3);
    private CountPowerDTO sumPower4 = new CountPowerDTO("Batman", 4);
    private CountPowerDTO sumPower5 = new CountPowerDTO("The Flash", 3);
    private CountPowerDTO sumPower6 = new CountPowerDTO("Green Arrow", 4);
    private CountPowerDTO sumPower7 = new CountPowerDTO("Supergirl", 1);
    private CountPowerDTO sumPower8 = new CountPowerDTO("Supergirl", 3);

    private List<Superhero> superheroes = new ArrayList<>(Arrays.asList(superhero1,superhero2,superhero3,superhero4,superhero5));
    private List<CityDTO> cities = new ArrayList<>(Arrays.asList(city1,city2,city3,city4,city5));
    private List<SuperpowerDTO> superpower = new ArrayList<>(Arrays.asList(superpower1,superpower2,superpower3,superpower4,superpower5, superpower6));
    private List<CountPowerDTO> sumPower = new ArrayList<>(Arrays.asList(sumPower1,sumPower2,sumPower3,sumPower4,sumPower5,sumPower6, sumPower7, sumPower8));


    // List with data so we can share the data throug other methods
    private List<CountPowerDTO> listOfSuperheroNameAndSumPower = new ArrayList<>();
    private List<CityDTO> cityAndSuperheroName = new ArrayList<>();

    @Override
    public List<Superhero> getSuperheroes(){
        List<Superhero> searchResults = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            searchResults.add(superhero);
        }
        return searchResults;
    }
    @Override
    public Superhero getSuperhero(String superheroName){
        Superhero superhero1 = null;
        for (Superhero superhero : superheroes) {
            String name = superhero.getSuperHeroName().toLowerCase();
            if (name.contains(superheroName.toLowerCase().trim())) {
                superhero1 = (new Superhero(superhero.getsuperheroId(),superhero.getSuperHeroName(), superhero.getReelName(), superhero.getCreationYear()));
            }
        }
        return superhero1;
    }
    @Override
    public List<CountPowerDTO> getSuperpowerCount(){

        CountPowerDTO countPowerDTO = null;
        int starPower = 1;
        for(CountPowerDTO superpower : sumPower){
            if(listOfSuperheroNameAndSumPower.contains(superpower)){
                int power = superpower.getPower();
                superpower.setPower(power +1);
            }else {
                countPowerDTO = new CountPowerDTO(superpower.getSuperheroName(), starPower);
            }
            listOfSuperheroNameAndSumPower.add(countPowerDTO);
        }

        return listOfSuperheroNameAndSumPower;

    }
    @Override
    public CountPowerDTO getCountPowerSuperheroName(String superheroName){
        CountPowerDTO countPowerDTO = null;
        for (CountPowerDTO superhero : listOfSuperheroNameAndSumPower){
            if(superhero.getSuperheroName().equals(superheroName)){
                countPowerDTO = superhero;
            }
        }
        return countPowerDTO;
    }
    @Override
    public List<CityDTO> getCity(){

        CityDTO city1 = null;
        for (CityDTO city : cities) {
            city1 = new CityDTO(city.getCity(), city.getSuperheroName());
            cityAndSuperheroName.add(city1);
        }
        return cityAndSuperheroName;
    }
    @Override
    public CityDTO getCitySuperheroName(String superheroName){
        CityDTO city1 = null;
        for (CityDTO city : cityAndSuperheroName){
            if(city.getSuperheroName().equals(superheroName)){
                city1 = city;
            }
        }
        return city1;
    }
}
