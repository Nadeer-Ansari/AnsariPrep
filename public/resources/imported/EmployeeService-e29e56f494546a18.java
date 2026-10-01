package example.spring.rest.data.jpa.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.spring.rest.data.jpa.entities.Department;
import example.spring.rest.data.jpa.entities.Employee;
import example.spring.rest.data.jpa.repositories.DepartmentRepository;
import example.spring.rest.data.jpa.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeReposistoryRef;
	
	@Autowired
	private DepartmentRepository departmentRepositoryRef;
	
	public Collection<Employee> retrieveAll(){
		return employeeReposistoryRef.findAll();
	}
	
	public Employee retrieveById(Integer empNo) {
		return employeeReposistoryRef.findById(empNo).orElse(null);
	}
	
	public void create(Employee newEmp) {
		//This method creates a new employee without dept.
		employeeReposistoryRef.save(newEmp);
	}
	
	public void create(Employee newEmp, Integer deptNo) {
		Department foundDepartment = 
		departmentRepositoryRef.findById(deptNo).orElse(null);
		if(foundDepartment != null) {
			//Add the new employee to the existing list of employees held by this dept.
			foundDepartment.addEmployee(newEmp);
			departmentRepositoryRef.save(foundDepartment);
		}
	}
	
	public void linkEmployeeWithDept(Integer empNo, Integer deptNo) {
		Employee foundEmployee = 
		employeeReposistoryRef.findById(empNo).orElse(null);
		
		Department foundDepartment =
		departmentRepositoryRef.findById(deptNo).orElse(null);
		
		if(foundEmployee != null && foundDepartment != null) {
			foundDepartment.addEmployee(foundEmployee);
			departmentRepositoryRef.save(foundDepartment);
		}
	}
	
}







