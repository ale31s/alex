package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Customer;
import model.Ticket;
import repository.Repo;
import static repository.Repo.customers;


public class CustomerService implements Repo{



    public void createCustomer() {
       

        Customer customer = new Customer();
        Scanner input = new Scanner(System.in);
        System.out.println("give name of customer");
        customer.setName(input.nextLine());
        
        System.out.println("give surname of customer");
        customer.setSurname(input.nextLine());
        
        System.out.println("give email of customer");
        
        String email = input.nextLine();
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);  
            System.out.println(email +" : "+ matcher.matches()+"\n");
        customer.setEmail(input.nextLine());
        
        System.out.println("give nationality of customer");
        customer.setNationality(input.nextLine());
        
        System.out.println("give the address of customer");
        customer.setAddress(input.nextLine());
        
        System.out.println("give category of customer");
        customer.setCategory(input.nextLine());
        
        System.out.println("give ID of customer");
        customer.setId(input.nextInt());
         customers.add(customer);
        System.out.println("u create this customer" + customer);

    }


    public BigDecimal Discount(BigDecimal price, String pay, String cat) {
        if (cat.equals("bsn")) {
            if (pay.equals("credit")) {
                BigDecimal d = new BigDecimal("0.2");
                price = price.subtract(price.multiply(d));
                return price;
            } else {
                BigDecimal d = new BigDecimal("0.1");
                price = price.subtract(price.multiply(d));
                return price;
            }
        } else {
            if (pay.equals("credit")) {
                BigDecimal d = new BigDecimal("0.1");
                price = price.add(price.multiply(d));
                return price;
            }
        }
        BigDecimal d = new BigDecimal("0.2");
        price = price.add(price.multiply(d));
        return price;
    }
}
