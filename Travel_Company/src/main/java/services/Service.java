
package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Customer;
import model.Ticket;
import repository.Repo;



public class Service implements Repo{
    // δεν μου εβρισκε το dependency
    //Collections.sort(Ticket,new Comparator<Ticket>())
    
    public void ShowAllCustomers(){
        System.out.println("ID   ,Name   ,Surname   ,Email   ,Nationality   ,Address   ,Category ");
        for (int i =0; i< customers.size(); i++){
            System.out.println(customers.get(i).getId()+ customers.get(i).getName() + 
                  customers.get(i).getSurname()+ customers.get(i).getEmail()+ customers.get(i).getNationality() +
                    customers.get(i).getAddress() + customers.get(i).getCategory());
        }
    
   }
    public void ShowAllTickets(){
        System.out.println("ticket ID   ,Customer ID   , Fight Code   , Payment Method    ,Amount   ");
        for (int i =0; i< tickets.size(); i++){
            System.out.println(tickets.get(i).getTicketId() + tickets.get(i).getCustomerID()+ 
                    tickets.get(i).getFlightNumber() + tickets.get(i).getPaymentMethod()
                     + tickets.get(i).getAmount());
        
        }
    }
   
    public BigDecimal compare (Ticket t1, Ticket t2){
        return BigDecimal.valueOf(t1.getAmount().compareTo(t2.getAmount()));
    }
    
    public void NoTicketsCustomers(){
        
        for (int i = 0; i <customers.size(); i++){
            boolean check = false;
            for(int y = 0; y < tickets.size(); y++){
                int x = customers.get(i).getId();
                int z = tickets.get(y).getCustomerID();
               if(x==z){
                   check = true;
               }
            }
            if(check = false){
                System.out.println(customers.get(i).getId());
            }
        }
          
    }
}
