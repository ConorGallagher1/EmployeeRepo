package kainos.groupProj.employeeStuff;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    private int EmpID;
    private static String name;
    private static String address;
    private static String NIN;
    private static String BAN;
    private static double startSal;
    private static double currentSal;
    private static int DeptID;

    @JsonCreator
    public Employee(@JsonProperty("Name")String newName, @JsonProperty("Address")String newAddress, @JsonProperty("NIN")String newNIN, @JsonProperty("BAN")String newBAN, @JsonProperty("StartingSalary")double newStartSal, @JsonProperty("CurrentSalary")double newCurrentSal, @JsonProperty("DepartmentID")int newDeptID)
    {

        name = newName;
        address = newAddress;
        NIN = newNIN;
        BAN = newBAN;
        startSal = newStartSal;
        currentSal = newCurrentSal;
        DeptID = newDeptID;
    }

    public Employee()
    {
        name = "Not Provided";
        address = "Not Provided";
        NIN = "Not Provided";
        BAN = "Not Provided";
        startSal = 0.0;
        currentSal = 0.0;
        DeptID = 0;
    }

    //CALC PAY METHOD (SPRINT B, US 5)
    public double calcPay() { // calculate monthly pay in pence
        return getCurrentSal() / 12;
    }


    //GETTERS AND SETTERS
    public int getEmpID() {
        return EmpID;
    }

    public void setEmpID(int empID) {
        EmpID = empID;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static String getNIN() {
        return NIN;
    }

    public void setNIN(String NIN) {
        this.NIN = NIN;
    }

    public static String getBAN() {
        return BAN;
    }

    public void setBAN(String BAN) {
        this.BAN = BAN;
    }

    public static double getStartSal() {
        return startSal;
    }

    public void setStartSal(double startSal) {
        this.startSal = startSal;
    }

    public static double getCurrentSal() {
        return currentSal;
    }

    public void setCurrentSal(double currentSal) {
        this.currentSal = currentSal;
    }

    public static int getDeptID() {
        return DeptID;
    }

    public void setDeptID(int deptID) {
        DeptID = deptID;
    }
}
