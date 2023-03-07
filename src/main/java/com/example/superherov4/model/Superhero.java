package com.example.superherov4.model;

public class Superhero {
    private int superheroId;
    private String superHeroName;
    private String reelName;
    private boolean isHuman;
    private String superPower;
    private int creationYear;
    private double powerLevel;
    private String city;

    //konstruktør
    public Superhero(int superheroId, String superHeroName, String reelName, boolean isHuman, String superPower, int creationYear, double powerLevel, String city) {
        this.superheroId = superheroId;
        this.superHeroName = superHeroName;
        this.reelName = reelName;
        this.isHuman = isHuman;
        this.superPower = superPower;
        this.creationYear = creationYear;
        this.powerLevel = powerLevel;
        this.city = city;
    }


    //Gettere
    public String getSuperHeroName() {
        return superHeroName;
    }
    public String getReelName() {
        return reelName;
    }
    public boolean isHuman() {
        return isHuman;
    }
    public String getSuperPower() {
        return superPower;
    }
    public int getCreationYear() {
        return creationYear;
    }
    public double getPowerLevel() {
        return powerLevel;
    }
    public String getCity() {
        return city;
    }
    public String toString() {
        return getSuperHeroName() + ", " + getSuperPower() + ", " + getReelName() + ", " + getCreationYear() + ", " + isHuman() + ", " + getPowerLevel();
    }


    public void setSuperheroName(String newSuperheroName) {
        this.superHeroName = newSuperheroName;
    }
    public void setReelName(String newReelName) {
        this.reelName = newReelName;
    }
    public void setSuperPower(String newSuperPower) {
        this.superPower = newSuperPower;
    }
    public void setCreationYear(String newCreationYear) {
        this.creationYear = Integer.parseInt(newCreationYear);
    }
    public void setIsHuman(boolean newIsHuman) {
        this.isHuman = newIsHuman;
    }
    public void setPowerLevel(String newPowerLevel) {
        this.powerLevel = Double.parseDouble(newPowerLevel);
    }
}

