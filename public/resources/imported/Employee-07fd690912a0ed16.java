package example.spring.rest.data.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee_Master")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_no")
	private Integer employeeNo;
	@Column(name = "emp_name", length = 40)
	private String name;
	@Column(name = "emp_sal")
	private int salary;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer employeeNo, String name, int salary) {
		super();
		this.employeeNo = employeeNo;
		this.name = name;
		this.salary = salary;
	}
	public Integer getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(Integer employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeNo=" + employeeNo + ", name=" + name + ", salary=" + salary + "]";
	}
	

}
