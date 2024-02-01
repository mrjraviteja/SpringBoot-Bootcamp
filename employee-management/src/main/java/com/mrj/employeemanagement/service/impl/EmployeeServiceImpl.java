package com.mrj.employeemanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
	public List<EmployeeEntity> findAllEmployee()
	{
		return employeeRepository.findAll();
	}
	
	@Override
	public Optional<EmployeeEntity> findById(Long id)
	{
		return employeeRepository.findById(id);
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
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
}
