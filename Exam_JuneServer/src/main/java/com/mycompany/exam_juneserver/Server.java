/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam_juneserver;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.xml.ws.Endpoint;

/**
 *
 * @author biar
 */
public class Server {

    public static void main(String args[]) throws InterruptedException, JMSException, NamingException {
        PMImpl implementor = new PMImpl();
        String address = "http://localhost:8080/ProfessorManagement";
        Endpoint.publish(address, implementor);
        System.out.println("--- SERVER IS UP ---");
        ProductRanking r = new ProductRanking();
            r.start();
    }
}
