/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam_julyclient;

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
        System.out.println("=== Benvenuto in BlockTascio");
        System.out.println("====================================");
        System.out.println("\n\n-- Scegli la tua operazione:");
        System.out.println("---- 1. Elenco film");
        System.out.println("---- 2. Dettagli film");
        System.out.print("\n---> Effettuare scelta: ");

        Scanner input = new Scanner(System.in);
        x = input.nextInt();

        switch (x) {
            case 1:   // addCustomer
                try { // Call Web Service Operation
                    com.mycompany.exam_julyserver.MovieImplService service = new com.mycompany.exam_julyserver.MovieImplService();
                    com.mycompany.exam_julyserver.Movie port = service.getMovieImplPort();
                    // TODO process result here
                    java.lang.String result = port.getAllMovies();
                    System.out.println("Result = "+result);
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
                break;
            case 2:   // detailsCustomers()
                
                try { // Call Web Service Operation
                    com.mycompany.exam_julyserver.MovieImplService service = new com.mycompany.exam_julyserver.MovieImplService();
                    com.mycompany.exam_julyserver.Movie port = service.getMovieImplPort();
                    // TODO initialize WS operation arguments here
                    int arg0 = 0;
                    System.out.print("Inserisci ID del film: ");
                    arg0 = input.nextInt();
                    System.out.println(arg0);
                    // TODO process result here
                    java.lang.String result = port.getMovie(arg0);
                    System.out.println("Result = "+result);
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }

                break;
            default:
        }

        System.out.println("\nSEE YA!");
    }
    
}
