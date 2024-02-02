package com.mrj.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import com.mrj.employeemanagement.controller.dto.DepartmentResponseDTO;
import com.mrj.employeemanagement.entity.DepartmentEntity;

public interface DepartmentService {
	Optional<DepartmentEntity> findById(Long id);
	List<DepartmentResponseDTO> findAllDepartments();
}
