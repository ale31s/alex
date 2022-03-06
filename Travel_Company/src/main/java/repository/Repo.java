
package repository;

import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Flight;
import model.Ticket;


public interface Repo {
        List<Customer> customers = new ArrayList<>();
    List<Ticket> tickets = new ArrayList<>();
    List<Flight> flights = new ArrayList<>();
    
    
}
