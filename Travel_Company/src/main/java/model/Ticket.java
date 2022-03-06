
package model;

import java.math.BigDecimal;
import services.CustomerService;



public class Ticket {
    private int FlightNumber;
    private int CustomerID;
    private int TicketId;
    private String PaymentMethod;
    private BigDecimal Amount;

    @Override
    public String toString() {
        return "Ticket{" + "FlightNumber=" + FlightNumber + ", CustomerID=" + CustomerID + ", TicketId=" + TicketId + ", PaymentMethod=" + PaymentMethod + ", Amount=" + Amount + '}';
    }

    
    
    public Ticket() {
    }
    
    public Ticket(int FlightNumber, int CustomerID, int TicketId, String PaymentMethod, BigDecimal Amount) {
        this.FlightNumber = FlightNumber;
        this.CustomerID = CustomerID;
        this.TicketId = TicketId;
        this.PaymentMethod = PaymentMethod;
        this.Amount = Amount;
    }

    
    
    
    public int getFlightNumber() {
        return FlightNumber;
    }

    public void setFlightNumber(int FlightNumber) {
        this.FlightNumber = FlightNumber;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public int getTicketId() {
        return TicketId;
    }

    public void setTicketId(int TicketId) {
        this.TicketId = TicketId;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal Amount) {
        this.Amount = Amount;
    }
  
    


    
    
    
}
