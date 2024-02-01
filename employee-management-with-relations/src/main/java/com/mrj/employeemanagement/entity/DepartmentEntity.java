package com.mrj.employeemanagement.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="mt_dept")
public class DepartmentEntity {
	
	@Id
	@Column(name="dept_id")
	private long deptId;
	
	@OneToOne(mappedBy="departmentEntity",cascade=CascadeType.ALL)
	private EmployeeEntity employeeEntity;
}
