package example.spring.rest.data.jpa.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.spring.rest.data.jpa.entities.Department;
import example.spring.rest.data.jpa.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepositoryRef;
	
	public Collection<Department> retrieveAll(){
		return departmentRepositoryRef.findAll();
	}
	
	public Department retrieveById(Integer deptId) {
		return departmentRepositoryRef.findById(deptId).orElse(null);
	}
	
	public void create(Department newDept) {
		departmentRepositoryRef.save(newDept);	
	}
	
}









