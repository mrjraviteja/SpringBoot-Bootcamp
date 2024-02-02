package com.mrj.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrj.employeemanagement.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long>{

	List<EmployeeEntity> findByDepartmentEntityDeptId(Long deptId);
}
