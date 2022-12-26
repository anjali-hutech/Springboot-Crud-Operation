package com.springboot.crud.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.model.Employee;
import com.springboot.crud.service.EmployeeService;

import jakarta.persistence.UniqueConstraint;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;


	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//build create employee REST API
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}

	//Build get all Employees REST API
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	//Build get employee by Id
    @GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
	}

    //build update employee REWST api
    
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
    		,@RequestBody Employee employee){
    	return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
    }
    
    //build delete employee Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
    {
    	//delete employee from db
    	employeeService.deleteEmployee(id);
    	
    	return new ResponseEntity<String>("Employee deleted successfully!.",HttpStatus.OK);
    }
    
    
    
}
