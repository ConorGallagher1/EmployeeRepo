package kainos.groupProj;
import kainos.groupProj.employeeStuff.*;

import java.sql.SQLException;
import java.util.List;
import java.util.OptionalDouble;

public class Access {
    public static void main(String[] args) throws SQLException {
        long t1, t2;
        List<Employee> bigEmps = EmployeesDB.getEmployees();
        t1 = System.nanoTime();
        OptionalDouble avgSalaries = bigEmps.stream()
                .mapToDouble(x->x.getCurrentSal()).average();
        System.out.println(String.format("Average salary is £%,.2f.",
                avgSalaries.getAsDouble()/100));
        t2 = System.nanoTime();
        System.err.println("Printing: Trace took "
                + (t2-t1) + " nanos.");

    }
}
