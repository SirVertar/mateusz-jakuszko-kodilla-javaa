package com.kodilla.good.patterns.jakuszkosairlines;

import java.util.HashMap;
import java.util.Map;

public class FlightDatabase {

    Map<Integer, Flight> flightMap = new HashMap<>();

    void addFlight(Flight... flights) {
        int i = flightMap.size();
        for (Flight flight: flights) {
            if (flight != null) {
                flightMap.put(flight.getFlightId(), flight);
                i++;
            }
            if (flightMap.size() != i) {
                System.out.println("You probably trying add the same flight into database");
                i++;
            }


        }
    }

    public Map<Integer, Flight> getFlightMap() {
        return flightMap;
    }
}
