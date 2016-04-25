package smla.services;

import smla.Track;
import smla.objects.Stock;
import smla.persistence.TestHibernate;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobyk on 25/04/16.
 */
@Path("/json/metallica")
public class JsonService {

    static TestHibernate hib = new TestHibernate();

    static String title = "Enter Sandman", singer = "Metallica";
    static List<Stock> users = new ArrayList<Stock>();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Stock> getTrackInJSON() {

        try {
            users = (List<Stock>) hib.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;

    }

    @PUT
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Stock usr) {

        String name = usr.getName();
        String nickname = usr.getNickname();
        String password = usr.getPassword();

        String result = "Track saved : " + usr;

        hib.addUser(usr);

        return Response.status(201).entity(result).build();

    }

}
