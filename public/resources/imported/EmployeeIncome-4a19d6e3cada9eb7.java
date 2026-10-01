package stream_api;

public class EmployeeIncome {
	private String empName;
	private float empAnnualSal;
	public EmployeeIncome() {
		// TODO Auto-generated constructor stub
	}
	public EmployeeIncome(String empName, float empAnnualSal) {
		super();
		this.empName = empName;
		this.empAnnualSal = empAnnualSal;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getEmpAnnualSal() {
		return empAnnualSal;
	}
	public void setEmpAnnualSal(float empAnnualSal) {
		this.empAnnualSal = empAnnualSal;
	}
	@Override
	public String toString() {
		return "EmployeeIncome [empName=" + empName + ", empAnnualSal=" + empAnnualSal + "]";
	}
	

}
