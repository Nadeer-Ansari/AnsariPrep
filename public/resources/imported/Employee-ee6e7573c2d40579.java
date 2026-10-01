package example.spring.core;

public class Employee {
	private int empNo;
	private String name;
	private float salary;
	public Employee() {
		System.out.println("Inside Employee()");
	}
	public Employee(int empNo, String name, float salary) {
		System.out.println("Inside Employee(int,String,float)");
		this.empNo = empNo;
		this.name = name;
		this.salary = salary;
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
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", name=" + name + ", salary=" + salary + "]";
	}

}
