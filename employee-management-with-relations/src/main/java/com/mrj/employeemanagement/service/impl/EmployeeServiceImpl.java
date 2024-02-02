package com.mrj.employeemanagement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mrj.employeemanagement.controller.dto.EmployeeResponseDTO;
import com.mrj.employeemanagement.entity.EmployeeEntity;
import com.mrj.employeemanagement.repository.EmployeeRepository;
import com.mrj.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository)
	{
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<EmployeeResponseDTO> findAllEmployee()
	{
		List<EmployeeEntity> employees = employeeRepository.findAll();
		return employees.stream().map(this::mapToEmployeeResponseDTO).collect(Collectors.toList());
	}
	
	private EmployeeResponseDTO mapToEmployeeResponseDTO(EmployeeEntity employeeEntity)
	{
		EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
		responseDTO.setId(employeeEntity.getId());
		responseDTO.setName(employeeEntity.getName());
        responseDTO.setGender(employeeEntity.getGender());
        responseDTO.setDateOfBirth(employeeEntity.getDateOfBirth());
        responseDTO.setAddress(employeeEntity.getAddress());
        
        if(employeeEntity.getDepartmentEntity() != null)
        {
        	responseDTO.setDept_id(employeeEntity.getDepartmentEntity().getDeptId());
        }
        
        return responseDTO;
	}
	
	@Override
	public EmployeeResponseDTO findById(Long id)
	{
		Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(id);
		
		if(employeeOptional.isPresent())
		{
			EmployeeEntity employeeEntity = employeeOptional.get();
			EmployeeResponseDTO responseDTO = mapToEmployeeResponseDTO(employeeEntity);
			return responseDTO;
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity)
	{
		return employeeRepository.save(employeeEntity);
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
		return employeeRepository.save(employeeEntity);
	}

	@Override
	public List<EmployeeResponseDTO> findByDeptId(Long deptId)
	{
		List<EmployeeEntity> employees = employeeRepository.findByDepartmentEntityDeptId(deptId);
		return employees.stream().map(this::mapToEmployeeResponseDTO).collect(Collectors.toList());
	}
	
	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
