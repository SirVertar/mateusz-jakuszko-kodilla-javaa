package com.kodilla.stream.world;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {
    @BeforeClass
    public static void startTests() {
        System.out.println("Test's of WorldTest are starting...");
    }

    @AfterClass
    public static void startEnds() {
        System.out.println("Test's of WorldTest have ended...");
    }

    @Test
    public void getPeopleQuantityTest() {
        //Given
        Country poland = new Country(new BigDecimal("22222222"));
        Country germany = new Country(new BigDecimal("33333333"));
        Country slovakia = new Country(new BigDecimal("44444444"));
        Country italy = new Country(new BigDecimal("55555555"));

        Country vietnam = new Country(new BigDecimal("66666666"));
        Country thailand = new Country(new BigDecimal("77777777"));
        Country malaysia = new Country(new BigDecimal("88888888"));

        Country argentina = new Country(new BigDecimal("66666666"));
        Country brazil = new Country(new BigDecimal("99999999"));
        Country chile = new Country(new BigDecimal("11111111"));

        List<Country> listOfCountryInEurope = new ArrayList<>();
        listOfCountryInEurope.add(poland);
        listOfCountryInEurope.add(germany);
        listOfCountryInEurope.add(slovakia);
        listOfCountryInEurope.add(italy);

        List<Country> listOfCountryInAsia = new ArrayList<>();
        listOfCountryInAsia.add(vietnam);
        listOfCountryInAsia.add(thailand);
        listOfCountryInAsia.add(malaysia);

        List<Country> listOfCountryInSouthAmerica = new ArrayList<>();
        listOfCountryInSouthAmerica.add(argentina);
        listOfCountryInSouthAmerica.add(brazil);
        listOfCountryInSouthAmerica.add(chile);

        Continent europe = new Continent(listOfCountryInEurope);
        Continent asia = new Continent(listOfCountryInAsia);
        Continent southAmerica = new Continent(listOfCountryInSouthAmerica);

        List<Continent> listOfContinents = new ArrayList<>();
        listOfContinents.add(europe);
        listOfContinents.add(asia);
        listOfContinents.add(southAmerica);


        World world = new World(listOfContinents);

        //When
        BigDecimal worldPopulation = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPopulation = new BigDecimal("566666661");
        Assert.assertEquals(expectedPopulation, worldPopulation);
    }

}
