package com.example.superherov4.dto;

import java.util.ArrayList;
import java.util.List;

public class CountPowerDTO {
    private String superheroName;
    private int power;

    public CountPowerDTO(String superheroName, int power){
        this.superheroName = superheroName;
        this.power = power;
    }


    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
