/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restclientlab2;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author biar
 */
public class MainClass {
    private static final String REST_URI = "http://localhost:8080/bank/operations/";

    private static Client client;

    public static void main(String[] args) {
        client = ClientBuilder.newBuilder().newClient();

        System.out.println(getResponseById(1));
        System.out.println(getOperationById(1).getDescription());
        
        Operation putO = new Operation(1, 7, "2015-06-01", 100, "Cena al Ristorante -- nuovo");
        System.out.println(putOperation(putO, Integer.toString(putO.getId())));
        
        
        Operation postO = new Operation(8, 7, "2015-06-01", 150, "Spesa al Conad");
        System.out.println(postOperation(postO, Integer.toString(postO.getId())));
        
        System.out.println(deleteOperation(3));

    }

    public static Response getResponseById(int id) {
        return client
                .target(REST_URI)
                .path(String.valueOf(id))
                .request(MediaType.TEXT_XML)
                .get();
    }

    public static Operation getOperationById(int id) {
        return client
                .target(REST_URI)
                .path(String.valueOf(id))
                .request(MediaType.TEXT_XML)
                .get(Operation.class);
    }
    
    public static Response putOperation(Operation putO, String path){
        return client
                .target(REST_URI)
                .path(path)
                .request(MediaType.TEXT_XML)
                .put(Entity.entity(putO, MediaType.TEXT_XML));
    }
    
    public static Response postOperation(Operation postO, String path){
        return client
                .target(REST_URI)
                .path(path)
                .request(MediaType.TEXT_XML)
                .post(Entity.entity(postO, MediaType.TEXT_XML));      
    }
    
    public static Response deleteOperation(int id){
        return client
                .target(REST_URI)
                .path(String.valueOf(id))
                .request(MediaType.TEXT_XML)
                .delete();
    }

}
