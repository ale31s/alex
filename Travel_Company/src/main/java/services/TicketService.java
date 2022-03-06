package services;

import java.math.BigDecimal;

import java.util.Scanner;

import model.Ticket;
import repository.Repo;

public class TicketService implements Repo {

    
    private int pos1;
    private int pos2;
    private boolean flag1 = false;
    private boolean flag2 = false;

    public void createTicket() {
        
        Scanner input = new Scanner(System.in);
        System.out.println("credit or cash ? ");
        String payment = input.nextLine();
        System.out.println("give customers ID");
        Ticket ticket = new Ticket();
        int id = input.nextInt();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                flag1 = true;
                pos1 = i;
                ticket.setCustomerID(id);
            }
        }
        System.out.println("give flight code");
        int fc = input.nextInt();
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightCode() == fc) {
                flag2 = true;
                pos2 = i;
                ticket.setFlightNumber(fc);
                break;
            }
        }
        if (flag1 = false) {
            System.out.println("no customer macht with this id ");
        }
        if (flag2 = false){
            System.out.println("no ticket with this id ");
        }

        CustomerService cs = new CustomerService();
        BigDecimal amount = cs.Discount(flights.get(pos2).getPrice(), payment, customers.get(pos1).getCategory());
        ticket.setAmount(amount);
        ticket.setPaymentMethod(payment);

        
        System.out.println("give ticket id ");
        int tid = input.nextInt();
        ticket.setTicketId(tid);

        tickets.add(ticket);
        System.out.println(ticket);

    }

}
