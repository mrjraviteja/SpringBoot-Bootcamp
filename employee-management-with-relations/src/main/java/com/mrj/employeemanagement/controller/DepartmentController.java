package com.mrj.employeemanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.employeemanagement.controller.dto.DepartmentResponseDTO;
import com.mrj.employeemanagement.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	@GetMapping
	public List<DepartmentResponseDTO> findAllDepartments()
	{
		return departmentService.findAllDepartments();
	}
}
