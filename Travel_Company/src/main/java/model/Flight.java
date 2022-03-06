
package model;

import java.math.BigDecimal;


public class Flight {
    private int FlightCode;
    private String Departure;
    private String Destination;
    private String Date;
    private BigDecimal Price;
    private int Capacity;
    private int AvailableSeats;
    private String Airline;

   
    

    public Flight() {
    }

    @Override
    public String toString() {
        return "Flight{" + "FlightCode=" + FlightCode + ", Departure=" + Departure + ", Destination=" + Destination + ", Date=" + Date + ", Price=" + Price + ", Capacity=" + Capacity + ", Airline=" + Airline + ", AvailableSeats=" + AvailableSeats + '}';
    }
    

    public Flight(int FlightCode, String Departure, String Destination, String Date, BigDecimal Price, int Capacity, int AvailableSeats,String Airline) {
        this.FlightCode = FlightCode;
        this.Departure = Departure;
        this.Destination = Destination;
        this.Date = Date;
        this.Price = Price;
        this.Capacity = Capacity;
        this.AvailableSeats = AvailableSeats;
        this.Airline = Airline;
    }

    public String getAirline() {
        return Airline;
    }

    public void setAirline(String Airline) {
        this.Airline = Airline;
    }
    

    public int getAvailableSeats() {
        return AvailableSeats;
    }

    public void setAvailableSeats(int AvailableSeats) {
        this.AvailableSeats = AvailableSeats;
    }
   
    

    public int getFlightCode() {
        return FlightCode;
    }

    public void setFlightCode(int FlightCode) {
        this.FlightCode = FlightCode;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String Departure) {
        this.Departure = Departure;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal Price) {
        this.Price = Price;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }
    
    
    
}
