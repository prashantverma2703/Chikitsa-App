package com.test.restdata;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("myresource")
public class MyResource {
	
	Dao d = new Dao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getUser() 
    {
       	ArrayList<User> list = d.getall();
    	return list;
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") String id) 
    {
    	User u = d.getUser(id);
    	return u;
    }
    
    /*@GET
    @Path("doctor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getData(@PathParam("id") String id) 
    {
    	User u = d.getData(id);
    	return u;
    }*/
    
}
