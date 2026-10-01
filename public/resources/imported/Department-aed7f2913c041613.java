package example.spring.rest.data.jpa.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "Department_Master")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_no")
	private Integer departmentNo;
	@Column(name = "dept_name", length = 20)
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_no")
	private List<Employee> employees;
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public Department(Integer departmentNo, String name, List<Employee> employees) {
		super();
		this.departmentNo = departmentNo;
		this.name = name;
		this.employees = employees;
	}
	public Integer getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(Integer departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public void addEmployee(Employee emp) {
		employees.add(emp);
	}
	@Override
	public String toString() {
		return "Department [departmentNo=" + departmentNo + ", name=" + name + ", employees=" + employees + "]";
	}
	
}
