package kainos.groupProj.employeeStuff;

public class Department {
    private int DeptID;
    private String DeptName;

    public Department(int newID, String newName){
        DeptID = newID;
        DeptName = newName;
    }

    //GETTERS AND SETTERS
    public int getDeptID() {
        return DeptID;
    }

    public void setDeptID(int deptID) {
        DeptID = deptID;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String departmentName) {
        DeptName = departmentName;
    }
}
