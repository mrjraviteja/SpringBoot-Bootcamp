package com.mrj.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.server.ResponseStatusException;

import com.mrj.employeemanagement.entity.EmployeeEntity;
import com.mrj.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List<EmployeeEntity> findAllEmployee()
	{
		return employeeService.findAllEmployee();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<EmployeeEntity>> findEmployeeById(@PathVariable("id") Long id)
	{
		Optional<EmployeeEntity> result = employeeService.findById(id);
		if(result.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(result);
		}
	}
	
	@PostMapping
	public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employeeEntity)
	{
		EmployeeEntity employee = employeeService.saveEmployee(employeeEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	
	@PutMapping
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity)
	{
		return employeeService.updateEmployee(employeeEntity);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") Long id)
	{
		employeeService.deleteEmployee(id);
		throw new ResponseStatusException(HttpStatus.NO_CONTENT);
	}
}
