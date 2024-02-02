package com.mrj.employeemanagement.controller;

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
import org.springframework.web.server.ResponseStatusException;

import com.mrj.employeemanagement.controller.dto.EmployeeRequestDTO;
import com.mrj.employeemanagement.controller.dto.EmployeeResponseDTO;
import com.mrj.employeemanagement.entity.DepartmentEntity;
import com.mrj.employeemanagement.entity.EmployeeEntity;
import com.mrj.employeemanagement.service.DepartmentService;
import com.mrj.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	private final DepartmentService departmentService;
	
	public EmployeeController(EmployeeService employeeService,DepartmentService departmentService)
	{
		this.employeeService = employeeService;
		this.departmentService = departmentService;
	}
	
	@GetMapping
	public List<EmployeeResponseDTO> findAllEmployee()
	{
		return employeeService.findAllEmployee();
	}
	
	@GetMapping("emp/{id}")
	public ResponseEntity<EmployeeResponseDTO> findEmployeeById(@PathVariable("id") Long id)
	{
		EmployeeResponseDTO result = employeeService.findById(id);
		if(result == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(result);
		}
	}
	
	@GetMapping("emp/dept/{dept_id}")
	public List<EmployeeResponseDTO> findEmployeeByDeptId(@PathVariable("dept_id") Long id)
	{
		return employeeService.findByDeptId(id);
	}
	
	@PostMapping
	public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeRequestDTO requestDTO)
	{
		DepartmentEntity departmentEntity = departmentService.findById(requestDTO.getDept_id())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Department not found"));
		
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setName(requestDTO.getName());
		employeeEntity.setGender(requestDTO.getGender());
	    employeeEntity.setDateOfBirth(requestDTO.getDateOfBirth());
	    employeeEntity.setAddress(requestDTO.getAddress());
	    employeeEntity.setDepartmentEntity(departmentEntity);
	    
	    EmployeeEntity savedEmployee = employeeService.saveEmployee(employeeEntity);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
	}
	
	@PutMapping
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity)
	{
		return employeeService.updateEmployee(employeeEntity);
	}
	
	@DeleteMapping("emp/{id}")
	public void deleteEmployee(@PathVariable("id") Long id)
	{
		employeeService.deleteEmployee(id);
		throw new ResponseStatusException(HttpStatus.NO_CONTENT);
	}
}
