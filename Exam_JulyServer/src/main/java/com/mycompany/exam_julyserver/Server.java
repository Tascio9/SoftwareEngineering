/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam_julyserver;

import javax.xml.ws.Endpoint;

/**
 *
 * @author biar
 */
public class Server {

    public static void main(String args[]) throws InterruptedException {
        MovieImpl implementor = new MovieImpl();
        String address = "http://localhost:8080/movie";
        Endpoint.publish(address, implementor);
        System.out.println("--- SERVER IS UP ---");
        while (true) {

        }
    }
}
