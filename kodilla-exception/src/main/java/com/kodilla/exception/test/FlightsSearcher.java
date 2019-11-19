package com.kodilla.exception.test;

import java.util.*;

public class FlightsSearcher {

    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> connections = new HashMap<>();
        connections.put("Chopin Airport", true);
        connections.put("Modlin Airport", false);
        connections.put("Lawica Airport", true);

        if (connections.get(flight.getArrivalAirport()) != null) {
            if (connections.get(flight.getArrivalAirport())) {
                System.out.println("There is connection to " + flight.getArrivalAirport());
            } else if (!connections.get(flight.getArrivalAirport())) {
                System.out.println("There isn't connection to " + flight.getArrivalAirport());
            }
        } else {
            throw new RouteNotFoundException("There is not such kind of route from these airport...");
        }
    }
}
