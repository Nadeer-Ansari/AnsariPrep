package example.spring.rest.data.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import example.spring.rest.data.jpa.entities.Department;

public interface DepartmentRepository 
extends JpaRepository<Department, Integer>{

}
