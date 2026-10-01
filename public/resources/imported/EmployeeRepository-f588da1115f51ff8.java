package example.spring.rest.data.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import example.spring.rest.data.jpa.entities.Employee;

public interface EmployeeRepository 
extends JpaRepository<Employee, Integer>{

}
