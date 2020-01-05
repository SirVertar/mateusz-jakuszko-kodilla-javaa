package com.kodilla.good.patterns.jakuszkosairlines;

import com.kodilla.good.patterns.jakuszkosairlines.io.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearcher {
    private FlightDatabase flightDatabase;

    FlightSearcher(FlightDatabase flightDatabase) {
        this.flightDatabase = flightDatabase;
    }

    List<Flight> searchFlightsFrom(City city) {
        List<Flight> temporaryListOfFlights = flightDatabase.getFlightMap().values().stream()
                .filter(e -> e.getConnectionFrom() == city)
                .collect(Collectors.toList());
        return temporaryListOfFlights;
    }

    List<Flight> searchFlightsTo(City city) {
        List<Flight> temporaryListOfFlights = flightDatabase.getFlightMap().values().stream()
                .filter(e -> e.getConnectionTo() == city)
                .collect(Collectors.toList());
        return temporaryListOfFlights;
    }

    List<Flight> searchDirectFlightsFromTo(City cityFrom, City cityTo) {
        List<Flight> directFlightsListOfFlights = flightDatabase.getFlightMap().values().stream()
                .filter(e -> e.getConnectionFrom() == cityFrom)
                .filter(e -> e.getConnectionTo() == cityTo)
                .collect(Collectors.toList());
        return directFlightsListOfFlights;
    }

    List<Flight[]> searchFlightsWithConnectionFromTo(City cityFrom, City cityTo) {
        List<Flight> listOfFlightsFrom = searchFlightsFrom(cityFrom);
        List<Flight> listOfFlightsTo = searchFlightsTo(cityTo);
        List<Flight[]> listOfFlightWithTransfer = new ArrayList<>();
        for (Flight flight: listOfFlightsFrom) {
            listOfFlightsTo.stream()
                    .filter(e -> e.getConnectionFrom() == flight.getConnectionTo())
                    .map(e -> new Flight[]{flight,e})
                    .forEach(listOfFlightWithTransfer::add);
        }
        return listOfFlightWithTransfer;
    }

    public FlightDatabase getFlightDatabase() {
        return flightDatabase;
    }

}
