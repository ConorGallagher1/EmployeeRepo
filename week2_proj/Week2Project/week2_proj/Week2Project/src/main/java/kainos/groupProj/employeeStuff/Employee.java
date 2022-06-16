package kainos.groupProj.employeeStuff;

public class Employee {
    private int EmpID;
    private String name;
    private String address;
    private String NIN;
    private String BAN;
    private double startSal;
    private double currentSal;
    private int DeptID;

    public Employee(String newName, String newAddress, String newNIN, String newBAN, double newStartSal, double newCurrentSal, int newDeptID)
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNIN() {
        return NIN;
    }

    public void setNIN(String NIN) {
        this.NIN = NIN;
    }

    public String getBAN() {
        return BAN;
    }

    public void setBAN(String BAN) {
        this.BAN = BAN;
    }

    public double getStartSal() {
        return startSal;
    }

    public void setStartSal(double startSal) {
        this.startSal = startSal;
    }

    public double getCurrentSal() {
        return currentSal;
    }

    public void setCurrentSal(double currentSal) {
        this.currentSal = currentSal;
    }

    public int getDeptID() {
        return DeptID;
    }

    public void setDeptID(int deptID) {
        DeptID = deptID;
    }
}
