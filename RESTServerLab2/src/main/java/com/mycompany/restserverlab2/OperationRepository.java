/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restserverlab2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author biar
 */
@Path("bank")
@Produces("text/xml")
public class OperationRepository {
    private List<Operation> operations = new LinkedList();
    
    public OperationRepository() {
        operations = Operation.createOp();
    }
    
    // REST Methods
    @GET
    @Path("operations/{opId}")
    public Operation getOperation(@PathParam("opId") int opId) {
        return findById(opId);
    }
    
    @POST
    @Path("operations/{opId}")
    public Response addOperation(@PathParam("opId") int opId, Operation op) {
        Operation existingOp = findById(opId);        
        if (existingOp == null) {
            operations.add(op);
            return Response.ok().build();
        }
        return Response.status(Response.Status.FORBIDDEN).build();
    }
    
    @PUT
    @Path("operations/{opId}")
    public Response updateOperation(@PathParam("opId") int opId, Operation op) {
        Operation existingOp = findById(opId);        
        if (existingOp == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (existingOp.equals(op)) {
            return Response.notModified().build();    
        }
        boolean removed = operations.remove(existingOp);
        operations.add(op);
        return Response.ok().build();
    }
    
    @DELETE
    @Path("operations/{opId}")
    public Response deleteOperation(@PathParam("opId") int opId) {
        Operation existingOp = findById(opId);       
        if (existingOp == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        operations.remove(existingOp);
        return Response.ok().build();
    }
    
    /*
    public List<Operation> getOperationByClientId(int clientId) {
        LinkedList<Operation> res = new LinkedList();
        for (Map.Entry<Integer, Operation> op : operations.entrySet()) {
            if (op.getValue().getClientId() == clientId)
                res.add(op.getValue());
        }
        return res;
    }
    */
    // MARK: Private methods
    private Operation findById(int id){
        Iterator<Operation> it = operations.iterator();
        Operation op;
        while (it.hasNext()) {
            op = it.next();
            if(op.getId() == id)
                return op;
        }
        return null;
    }
}
