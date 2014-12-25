/*
 * Project : MyFirstRestApp
 * Description: First JAX-RS application
 * Date: 7/12/2014
 */
package org.sampath.restapp.myfirstrestapp.core;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.sampath.restapp.myfirstrestapp.model.User;

/**
 * @author SAMPATH
 */

@Path("usersAlt")
public class UserServiceAlter {
    
    //First simple method
    //http://localhost:8080/MyFirstRestApp/resources/usersAlt/user
    @Path("user")
    @GET
    public String getUser(){
        return "Hallooo... This is Sampath and this is my first JAX-RS application!";
    }
    
    //Implement with JAXB for XML format
    //http://localhost:8080/MyFirstRestApp/resources/usersAlt/user
    //Add Header Accept - text/xml 
    @GET
    @Path("user")
    @Produces("text/xml")
    public User getXmlData(String userName){
        return new User(Integer.valueOf("1"),"Sampath");
    }
    
    //Get json user data
    //http://localhost:8080/MyFirstRestApp/resources/usersAlt/user
    //Add Header Accept - application/json
    @GET
    @Path("user")
    @Produces("application/json")
    public User getJsonDate(String userName){
        return new User(Integer.valueOf("1"),"Sampath");
    }
    
}
