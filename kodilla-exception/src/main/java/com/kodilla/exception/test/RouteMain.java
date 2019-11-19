package com.kodilla.exception.test;

public class RouteMain {
    public static void main(String[] args) {

        Flight flightToChopinAirport = new Flight("Wroclaw Airport", "Chopin Airport");
        Flight flightToModlinAirport = new Flight("Wroclaw Airport", "Modlin Airport");
        Flight flightToWrongAirport = new Flight("Wroclaw Airport", "Wrong Airport");

        FlightsSearcher flightsSearcher = new FlightsSearcher();

        try {
            flightsSearcher.findFlight(flightToChopinAirport);
        } catch (RouteNotFoundException e) {
            System.out.println(e);
        } finally {
            System.out.println("Ready for next searching... \n");
        }

        try {
            flightsSearcher.findFlight(flightToModlinAirport);
        } catch (RouteNotFoundException e) {
            System.out.println(e);
        } finally {
            System.out.println("Ready for next searching... \n");
        }

        try {
            flightsSearcher.findFlight(flightToWrongAirport);
        } catch (RouteNotFoundException e) {
            System.out.println(e);
        } finally {
            System.out.println("Ready for next searching... \n");
        }

        System.out.println("Choose a airport where u wanna go to...");

    }
}
