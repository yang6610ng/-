import java.util.List;

public class UIData {
	
	private List<Employee> employees;
	private Employee employee;
	private String action;

	private String employeeid;
	
	
	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public String getAction() {
		return action;
	}
}