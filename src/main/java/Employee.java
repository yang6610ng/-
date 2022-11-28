public class Employee {
	 
    private String empNo;
    private String empName;
    private String position;
 
    public Employee() {
 
    }
 
    public Employee(String empNo, String empName, String position) {
        this.empNo = empNo;
        this.empName = empName;
        this.position = position;
    }
 
    public String getEmpNo() {
        return empNo;
    }
 
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
 
    public String getEmpName() {
        return empName;
    }
 
    public void setEmpName(String empName) {
        this.empName = empName;
    }
 
    public String getPosition() {
        return position;
    }
 
    public void setPosition(String position) {
        this.position = position;
    }
 
}