/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapserver;

import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author biar
 */
@WebService
public interface Bank {
    public String detailsCustomer(int id);

    public String addCustomer(Customer customer);
    
    public List<Customer> getCustomers();
    
}
