public class project {

    private int projID;
    private String projName;

    public project(int projID, String projName){
        this.setProjID(projID);
        this.setProjName(projName);
    } //first constructor

    public int getProjID() {
        return projID;
    }

    public void setProjID(int projID) {
        this.projID = projID;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }
} //end class


