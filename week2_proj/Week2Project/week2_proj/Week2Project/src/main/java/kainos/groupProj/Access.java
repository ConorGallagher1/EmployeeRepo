package kainos.groupProj;
import kainos.groupProj.employeeStuff.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import java.util.OptionalDouble;
@Path("/api")
public class Access {
    @GET
    @Path("/print/{msg}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMsg(@PathParam("msg") String message) {
        return "Hello from a RESTful Web service: " + message;
    }

    @POST
    @Path("/print")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String sendMsg(kainos.groupProj.Message message) {
        return "Hello from a RESTful Web service: " + message.getText();
    }
}
