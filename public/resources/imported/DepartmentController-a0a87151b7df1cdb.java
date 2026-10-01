package example.spring.rest.data.jpa.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.spring.rest.data.jpa.entities.Department;
import example.spring.rest.data.jpa.services.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentServiceRef;
	
	@GetMapping
	public Collection<Department> retrieveAll(){
		return departmentServiceRef.retrieveAll();
	}
	@GetMapping("/{deptNo}")
	public ResponseEntity<Department> 
	retrieveById(@PathVariable Integer deptNo) {
		ResponseEntity<Department> responseEntityRef = 
				ResponseEntity.notFound().build();
		
		Department foundDepartment = 
				departmentServiceRef.retrieveById(deptNo);
		if(foundDepartment != null)
			responseEntityRef = ResponseEntity.ok(foundDepartment);		
		return responseEntityRef;
	}
	@PostMapping
	public void create(@RequestBody Department newDept) {
		departmentServiceRef.create(newDept);
	}
}







