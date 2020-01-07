package com.kodilla.good.patterns.jakuszkosairlines.io;

import com.kodilla.good.patterns.jakuszkosairlines.Flight;

import java.util.List;

public abstract class Printer {

    public static void printFlightList(List<Flight> listOfFlight) {
        for (Flight flight : listOfFlight) {
            System.out.println(flight);
        }
    }

    public static void printFlightList(String beforeString, List<Flight> listOfFlight) {
        System.out.println(beforeString + "\n");
        for (Flight flight : listOfFlight) {
            System.out.println(flight);
        }
    }

    public static void printFlightTableInList(String beforeString, List<Flight[]> listOfFlight) {
        System.out.println(beforeString + "\n");
        int j = 1;
        for (Flight[] flight : listOfFlight) {
            System.out.println("[ " + j + " ]   " + "CONNECTION: ");
            j++;
            for (Flight value : flight) {
                System.out.println(value);
            }
        }
    }
}
