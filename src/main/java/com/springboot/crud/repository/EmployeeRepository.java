package com.springboot.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , Long>{

	

	

	
}
