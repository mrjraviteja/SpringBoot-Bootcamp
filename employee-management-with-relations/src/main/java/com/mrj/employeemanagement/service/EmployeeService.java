package com.mrj.employeemanagement.service;

import java.util.List;

import com.mrj.employeemanagement.controller.dto.EmployeeResponseDTO;
import com.mrj.employeemanagement.entity.EmployeeEntity;

public interface EmployeeService {
	List<EmployeeResponseDTO> findAllEmployee();
	EmployeeResponseDTO findById(Long id);
	EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
	EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
	List<EmployeeResponseDTO> findByDeptId(Long deptId);
	void deleteEmployee(Long id);
}
