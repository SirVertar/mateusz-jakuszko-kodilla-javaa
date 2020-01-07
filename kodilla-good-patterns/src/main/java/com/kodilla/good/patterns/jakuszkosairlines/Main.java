package com.kodilla.good.patterns.jakuszkosairlines;

import com.kodilla.good.patterns.jakuszkosairlines.io.Printer;

public class Main {
    public static void main(String[] args) {
        Flight flight1 = new Flight(City.POZNAN, City.GDANSK, Airlines.LOT, 1);
        Flight flight2 = new Flight(City.POZNAN, City.WARSAW, Airlines.LUFTHANSA,2);
        Flight flight3 = new Flight(City.POZNAN, City.WROCLAW, Airlines.LOT,3);
        Flight flight4 = new Flight(City.WARSAW, City.BERLIN, Airlines.QATAR,4);
        Flight flight5 = new Flight(City.WARSAW, City.BANGKOK, Airlines.QATAR,5);
        Flight flight6 = new Flight(City.WARSAW, City.GDANSK, Airlines.ETIHAD,6);
        Flight flight7 = new Flight(City.WARSAW, City.POZNAN, Airlines.QATAR,7);
        Flight flight8 = new Flight(City.WARSAW, City.WROCLAW, Airlines.ETIHAD,8);
        Flight flight9 = new Flight(City.WROCLAW, City.BANGKOK, Airlines.QATAR,9);
        Flight flight10 = new Flight(City.GDANSK, City.BANGKOK, Airlines.LUFTHANSA,10);


        FlightDatabase flightDatabase = new FlightDatabase();
        flightDatabase.addFlight(flight1, flight2, flight3, flight4, flight5, flight6, flight7, flight8, flight9, flight10);

        FlightSearcher flightSearcher = new FlightSearcher(flightDatabase);

        Printer.printFlightList("____Flights from Poznan____",
                flightSearcher.searchFlightsFrom(City.POZNAN));
        Printer.printFlightList("____Flights to Bangkok____",
                flightSearcher.searchFlightsTo(City.BANGKOK));
        Printer.printFlightList("____Direct flights from Warsaw to Bangkok____",
                flightSearcher.searchDirectFlightsFromTo(City.WARSAW, City.BANGKOK));
        Printer.printFlightTableInList("____Flights with Connection from Poznan to Bangkok____",
                flightSearcher.searchFlightsWithConnectionFromTo(City.POZNAN, City.BANGKOK));
    }
}
