package kainos.groupProj;
import kainos.groupProj.employeeStuff.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/api")
@Api("Engineering Academy Dropwizard API")
public class WebService {
    @GET
    @Path("/print/users")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMsg(@PathParam("msg") String message) {
        return "Hello from a RESTful Web service: " + message;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addEmp(kainos.groupProj.employeeStuff.Employee emp) throws SQLException {
        EmployeesDB edb = new EmployeesDB();
        edb.setEmployee(emp);
        return "Employee Details: " + emp.getName()
                + " " + emp.getAddress()
                + " " + emp.getNIN()
                + " " + emp.getBAN()
                + " " + emp.getStartSal()
                + " " + emp.getCurrentSal()
                + " " + emp.getDeptID();
    }

    @POST
    @Path("/print/db")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEMP() throws SQLException {
        return "Here are the employees: " + EmployeesDB.getEmployeeDepartments();
    }
}
