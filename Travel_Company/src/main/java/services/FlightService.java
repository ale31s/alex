package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Flight;
import static repository.Repo.flights;

public class FlightService {

    public void createFlight() {

        Flight flight = new Flight();
        Scanner input = new Scanner(System.in);
        System.out.println("give Airline");
        flight.setAirline(input.nextLine());
        System.out.println("give flight departure airport");
        flight.setDeparture(input.nextLine());
        System.out.println("give flight destination airport");
        flight.setDestination(input.nextLine());
        System.out.println("give flight date");
        flight.setDate(input.nextLine());
        System.out.println("give flight code");
        flight.setFlightCode(input.nextInt());
        System.out.println("give flight capacity");
        int x = input.nextInt();
        flight.setCapacity(x);
        flight.setAvailableSeats(x);
        System.out.println("give flight price");
        flight.setPrice(input.nextBigDecimal());

        flights.add(flight);
        System.out.println("you create that flight " + flight);

    }

  

   


}
