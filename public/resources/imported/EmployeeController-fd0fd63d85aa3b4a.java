package example.spring.rest.data.jpa.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.spring.rest.data.jpa.entities.Employee;
import example.spring.rest.data.jpa.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeServiceRef;
	@GetMapping
	public Collection<Employee> retrieveAll(){
		return employeeServiceRef.retrieveAll();
	}
	@GetMapping("/{empNo}")
	public ResponseEntity<Employee> 
	retrieveById(@PathVariable Integer empNo){
		ResponseEntity<Employee> responseEntityRef =
				ResponseEntity.notFound().build();
		Employee foundEmployee = 
				employeeServiceRef.retrieveById(empNo);
		if(foundEmployee != null)
			responseEntityRef = ResponseEntity.ok(foundEmployee);		
		return responseEntityRef;
	}
	@PostMapping //Create Employee without Dept
	public void create(@RequestBody Employee newEmp) {
		employeeServiceRef.create(newEmp);
	}
	
	@PostMapping("/{deptNo}") //Create Employee with Dept
	public void create
	(@RequestBody Employee newEmp, @PathVariable Integer deptNo) {
		employeeServiceRef.create(newEmp, deptNo);
	}
	
	@PutMapping("/{empNo}/{deptNo}")
	public void linkEmployeeToDept(
			@PathVariable Integer empNo,
			@PathVariable Integer deptNo
			) {
		employeeServiceRef.linkEmployeeWithDept(empNo, deptNo);
	}
	
	
}









