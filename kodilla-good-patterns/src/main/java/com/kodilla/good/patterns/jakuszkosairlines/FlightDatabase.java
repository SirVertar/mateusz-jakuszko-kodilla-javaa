package com.kodilla.good.patterns.jakuszkosairlines;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class FlightDatabase {

    Set<Flight> flightSet = new HashSet<>();

    void addFlight(Flight... flights) {
        flightSet.addAll(Arrays.asList(flights));
    }

        Set<Flight> getFlightSet () {
            return flightSet;
        }
    }
