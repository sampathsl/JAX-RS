/*
 * Project : MyFirstRestApp
 * Description: First JAX-RS application
 * Date: 7/12/2014
 */
package org.sampath.restapp.myfirstrestapp.core;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.sampath.restapp.myfirstrestapp.model.User;

/**
 * @author SAMPATH
 */

@Path("users")
public class UserService {
    
    //First simple method
    //http://localhost:8080/MyFirstRestApp/resources/users/user
    @Path("user")
    @GET
    public String getUser(){
        return "Hallooo... This is Sampath and this is my first JAX-RS application!";
    }
    
    //REST - implementing path parameters
    //http://localhost:8080/MyFirstRestApp/resources/users/id/1234567
    @GET
    @Path("id/{identifier}")
    public String getUserById(@PathParam("identifier") String userId){
        return userId;
    }
    
    //REST - implementing path parameters with query parameters
    //http://localhost:8080/MyFirstRestApp/resources/users/userName/Sampath?sortedBy=Name
    @GET
    @Path("userName/{identifier}")
    public String getUserDataBySort(@PathParam("identifier") String userName , @QueryParam("sortedBy") String sortedBy){
        return "User "+userName+" sorted by " + sortedBy;
    }
    
    //REST - implementing more restricted path parameters
    //http://localhost:8080/MyFirstRestApp/resources/users/userNameValue/Sampath
    @GET
    @Path("userNameValue/{identifier : [A-Z][a-z]*}")
    public String getUserByName(@PathParam("identifier") String userName){
        return userName;
    }
    
    //Implement with JAXB for XML format
    //http://localhost:8080/MyFirstRestApp/resources/users/user/xml
    @GET
    @Path("user/xml")
    @Produces("text/xml")
    public User getXmlData(String userName){
        return new User(Integer.valueOf("1"),"Sampath");
    }
    
    //Get json user data
    //http://localhost:8080/MyFirstRestApp/resources/users/user/json
    @GET
    @Path("user/json")
    @Produces("application/json")
    public User getJsonDate(String userName){
        return new User(Integer.valueOf("1"),"Sampath");
    }
    
    //Validate the parameters
    //http://localhost:8080/MyFirstRestApp/resources/users/badParam/userName/Sampath?sortedBy=
    @GET
    @Path("badParam/userName/{identifier}")
    public String getUserDataWithBadParam(@PathParam("identifier") String userName , @QueryParam("sortedBy") String sortedBy){
        if(sortedBy == null || sortedBy.equals("")){
            throw new WebApplicationException(Response.status(Status.BAD_REQUEST).header("x-error-msg","Sorted By is required").build());
        }
        return "User "+userName+" sorted by " + sortedBy;
    }
    
}
