/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restserverlab2;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author biar
 */
@XmlRootElement(name = "Operation")
public class Operation {
    private int id;
    private int clientId;
    private String date;
    private int amount;
    private String description;

    public Operation() {
    }

    public Operation(int id, int clientId, String date, int amount, String description) {
        this.id = id;
        this.clientId = clientId;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + this.clientId;
        hash = 53 * hash + this.amount;
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Operation other = (Operation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.clientId != other.clientId) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    public static List<Operation> createOp() {
        LinkedList<Operation> operations = new LinkedList<>();
        operations.add(new Operation(1, 1, "2015-06-01", 150, "Cena al ristorante"));
        operations.add(new Operation(2, 2, "2015-06-01", 10, "Cancelleria"));
        operations.add(new Operation(3, 3, "2015-06-01", 250, "Riparazione pc"));
        operations.add(new Operation(4, 1, "2015-06-01", 160, "Regalo Osvaldo"));
        operations.add(new Operation(5, 2, "2015-06-01", 170, "Cammello"));
        operations.add(new Operation(6, 3, "2015-06-01", 40, "Ali Baba"));
        return operations;
    }

}


    