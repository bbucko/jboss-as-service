package pl.iogreen.jboss.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Path("/library")
@Produces({"application/json"})
@Consumes({"application/json"})
public class ExampleService {

    @GET
    @Produces("text/plain")
    public String helloResource() {
        return "Hello! It's " + new Date();
    }

    @GET
    @Path("/books")
    public Collection<Book> getBooks() {
        return Arrays.asList(new Book("Hello", "World"));
    }

}
