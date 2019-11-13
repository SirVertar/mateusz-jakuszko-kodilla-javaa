package com.kodilla.stream.world;

import java.util.List;

public class Continent {
    private final List<Country> listOfCountry;

    public Continent(final List<Country> listOfCountry) {
        this.listOfCountry = listOfCountry;
    }

    public List<Country> getListOfCountry() {
        return listOfCountry;
    }
}
