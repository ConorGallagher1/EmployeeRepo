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

    public static int setEmployee(Employee emp) throws SQLException {
        Connection c = getConnection();
        Statement st = c.createStatement();

        String insertStatement = ("INSERT INTO employee_info(Name, Address, NIN, BAN, StartingSalary, CurrentSalary, DepartmentID) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)");

        PreparedStatement preparedStatement = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, emp.getName());
        preparedStatement.setString(2, emp.getAddress());
        preparedStatement.setString(3, emp.getNIN());
        preparedStatement.setString(4, emp.getBAN());
        preparedStatement.setDouble(5, emp.getStartSal());
        preparedStatement.setDouble(6, emp.getCurrentSal());
        preparedStatement.setInt(7, emp.getDeptID());

        int affectedRows = preparedStatement.executeUpdate();
        if(affectedRows == 0){
            throw new SQLException("Creating user failed, no rows affected");
        }
        int empNo = 0;
        try(ResultSet rs = preparedStatement.getGeneratedKeys()){
            if(rs.next()){
                empNo = rs.getInt(1);
            }
        }

        return empNo;
    }

    public static List getEmployeeDepartments() throws SQLException{
        Connection c = getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT EmployeeID, Name, DepartmentID FROM employee_info order by DepartmentID asc");
        ArrayList<Object> List = new ArrayList();
        while (rs.next()) {
            List.add(rs.getInt("EmployeeID"));
            List.add(rs.getString("Name"));
            List.add(rs.getInt("DepartmentID"));
        }
        return List;
    }
}

