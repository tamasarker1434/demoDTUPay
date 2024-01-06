package org.acme;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.Models.Customer;
import org.acme.Models.Trade;

import java.util.List;


@Path("/")
public class GeneralResources {
    private GeneralServices generalServices = new GeneralServices();
    @Path("/customers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> listRegDtuPayUser(){
        return generalServices.getAllCustomers();
    }

    @Path("/customers")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String regDtuPayUser(Customer customer){
        int result = generalServices.addNewDtuPayUser(customer);
        if (result>0) return String.valueOf(result);
        else return "User is not found or No bank Account found";
    }

   //Trading Controllers
    @Path("/trades")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trade> getAllTrades(){
        return generalServices.getAllTrades();
    }

    @Path("/trades")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trade> addNewTrades(Trade trade) {
        return generalServices.addTrade(trade);
    }
}
