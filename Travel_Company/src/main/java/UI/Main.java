
package UI;


import static repository.Repo.flights;
import services.CustomerService;
import services.FlightService;
import services.Service;
import services.TicketService;


public class Main {
        public static void main(String[] args) {
            
            
            //creating data
        FlightService f = new FlightService();
        f.createFlight();
        CustomerService c = new CustomerService();
        c.createCustomer();
        TicketService t = new TicketService();
        t.createTicket();
        // reporting
        Service se = new Service();
        

    }
    
}
