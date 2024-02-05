package com.mrj.employeemanagement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mrj.employeemanagement.controller.dto.DepartmentResponseDTO;
import com.mrj.employeemanagement.entity.DepartmentEntity;
import com.mrj.employeemanagement.repository.DepartmentRepository;
import com.mrj.employeemanagement.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	private final DepartmentRepository departmentRepository;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	@Override
	public Optional<DepartmentEntity> findById(Long id) {
		return departmentRepository.findById(id);
	}
	
	@Override
	public List<DepartmentResponseDTO> findAllDepartments()
	{
		List<DepartmentEntity> departments = departmentRepository.findAll();
		return departments.stream().map(this::mapToDepartmentResponseDTO).collect(Collectors.toList());
	}
	
	private DepartmentResponseDTO mapToDepartmentResponseDTO(DepartmentEntity departmentEntity)
	{
		DepartmentResponseDTO responseDTO = new DepartmentResponseDTO();
		responseDTO.setDeptId(departmentEntity.getDeptId());
		responseDTO.setDeptName(departmentEntity.getDeptName());
		responseDTO.setCreatedDate(departmentEntity.getCreatedDate());
		responseDTO.setLastModifiedDate(departmentEntity.getLastModifiedDate());
		
		if(!(departmentEntity.getLocations().isEmpty()))
		{
			responseDTO.setLocations(departmentEntity.getLocations());
		}
		
		return responseDTO;
	}

}
