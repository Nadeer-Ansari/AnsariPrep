package stream_api;

public class Employee {
	private int empNo;
	private String name;
	private float sal;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int empNo, String name, float sal) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.sal = sal;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", name=" + name + ", sal=" + sal + "]";
	}
	

}
