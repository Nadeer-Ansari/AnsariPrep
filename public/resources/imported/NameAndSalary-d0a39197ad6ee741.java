package example.hibernate.bean;

public class NameAndSalary {
	private String empName;
	private float empSal;
	
	public NameAndSalary() {
		
	}
	public NameAndSalary(String empName, float empSal) {
		super();
		this.empName = empName;
		this.empSal = empSal;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getEmpSal() {
		return empSal;
	}
	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return "NameAndSalary [empName=" + empName + ", empSal=" + empSal + "]";
	}
	
}
