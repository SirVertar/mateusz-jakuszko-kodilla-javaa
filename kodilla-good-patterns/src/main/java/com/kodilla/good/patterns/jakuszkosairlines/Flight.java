package com.kodilla.good.patterns.jakuszkosairlines;

import java.util.Objects;

public class Flight {

    private City connectionFrom;
    private City connectionTo;
    private Airlines airlines;
    private Integer flightId;

    Flight(City connectionFrom, City connectionTo, Airlines airlines, Integer flightId) {
        this.connectionFrom = connectionFrom;
        this.connectionTo = connectionTo;
        this.airlines = airlines;
        this.flightId = flightId;
    }

    City getConnectionFrom() {
        return connectionFrom;
    }

    City getConnectionTo() {
        return connectionTo;
    }

    @Override
    public String toString() {
        return "connectionFrom:  " + connectionFrom +
                "\nconnectionTo:  " + connectionTo +
                "\nairlines:  " + airlines +
                "\nflightId:  " + flightId + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return connectionFrom == flight.connectionFrom &&
                connectionTo == flight.connectionTo &&
                airlines == flight.airlines &&
                Objects.equals(flightId, flight.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionFrom, connectionTo, airlines, flightId);
    }
}
