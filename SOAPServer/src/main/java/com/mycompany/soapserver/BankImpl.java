/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapserver;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author biar
 */
@WebService(endpointInterface = "com.mycompany.soapserver.Bank")
public class BankImpl implements Bank {
    List<Customer> listOfCustomer = new ArrayList<>();
    
    Customer c1 = new Customer(1,"Sergio","Picca",29.00);
    Customer c2 = new Customer(2, "Gianluca", "Tasciotti", 12.00);
    
    {
        listOfCustomer.add(c1);
        listOfCustomer.add(c2);
    }
    
    @Override
    public String detailsCustomer(int id) {
        for(Customer c : listOfCustomer){
            if(c.getId() == id){       
                return "Customer details: -Name: " + c.getName() + "\n -Surname: " + c.getSurname() + "\n";
            }
        }
       return "NOT FOUND \n";
    }

    @Override
    public String addCustomer(Customer customer) {
        listOfCustomer.add(customer);
        return "New customer added!\n";
    }

    @Override
    public List<Customer> getCustomers() {
        return listOfCustomer;
    }
    
    
    
}
