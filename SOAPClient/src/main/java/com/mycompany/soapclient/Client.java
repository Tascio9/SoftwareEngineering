/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapclient;

import java.util.Scanner;

/**
 *
 * @author biar
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int x = 0;

        System.out.println("====================================");
        System.out.println("=== Benvenuto nella Banca del Tascio");
        System.out.println("====================================");
        System.out.println("\n\n-- Scegli la tua operazione:");
        System.out.println("---- 1. Aggiungi cliente:");
        System.out.println("---- 2. Dettagli client:");
        System.out.println("---- 3. Visualizza clienti:");
        System.out.print("\n---> Effettuare scelta: ");

        Scanner input = new Scanner(System.in);
        x = input.nextInt();

        switch (x) {
            case 1:   // addCustomer
                
                try { // Call Web Service Operation
                    com.mycompany.soapserver.BankImplService service = new com.mycompany.soapserver.BankImplService();
                    com.mycompany.soapserver.Bank port = service.getBankImplPort();
                    // TODO initialize WS operation arguments here
                    com.mycompany.soapserver.Customer arg0 = new com.mycompany.soapserver.Customer();
                    arg0.setId(3);
                    arg0.setName("Andrea");
                    arg0.setSurname("Napoletani");
                    arg0.setBill(0.00);
                    // TODO process result here
                    java.lang.String result = port.addCustomer(arg0);
                    System.out.println("Result = "+result);
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
                break;
            case 2:   // detailsCustomers()
                try { // Call Web Service Operation
                    com.mycompany.soapserver.BankImplService service = new com.mycompany.soapserver.BankImplService();
                    com.mycompany.soapserver.Bank port = service.getBankImplPort();
                    // TODO initialize WS operation arguments here
                    int arg0 = 3;
                    // TODO process result here
                    java.lang.String result = port.detailsCustomer(arg0);
                    System.out.println("Result = "+result);
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
                break;
            case 3:   // getCustomers()
                try { // Call Web Service Operation
                    com.mycompany.soapserver.BankImplService service = new com.mycompany.soapserver.BankImplService();
                    com.mycompany.soapserver.Bank port = service.getBankImplPort();
                    // TODO process result here
                    java.util.List<com.mycompany.soapserver.Customer> result = port.getCustomers();                   
                    System.out.println("Result = "+result);
                    for(com.mycompany.soapserver.Customer c : result){
                        System.out.println(c.getName() + c.getSurname());
                    }
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
            default:
        }

        System.out.println("\nSEE YA!");
    }

}
