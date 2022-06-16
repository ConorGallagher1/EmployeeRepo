package kainos.groupProj;

import kainos.groupProj.employeeStuff.Employee;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeesDB {
    private static Connection conn;

    private static Connection getConnection() {
        String user;
        String password;
        String host;

        if (conn != null) {
            return conn;
        }

        try {
            FileInputStream propsStream =
                    new FileInputStream("employeesdb.properties");

            Properties props = new Properties();
            props.load(propsStream);

            user            = props.getProperty("user");
            password        = props.getProperty("password");
            host            = props.getProperty("host");

            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain "
                                + "user, password, and host properties.");

            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/employee_StuartA?allowPublicKeyRetrieval=true&useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Employee> getEmployees() throws SQLException {
        Connection c = getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * "
                        + "FROM employee_info;");

        List<Employee> employees = new ArrayList<>();

        while (rs.next()) {
            Employee employee = new Employee(
                    rs.getString("Name"),
                    rs.getString("Address"),
                    rs.getString("NIN"),
                    rs.getString("BAN"),
                    rs.getDouble("StartingSalary"),
                    rs.getDouble("CurrentSalary"),
                    rs.getInt("DepartmentID")
            );
            employees.add(employee);
        }
        return employees;
    }
}
