package com.mrj.employeemanagement.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="mt_dept")
public class DepartmentEntity {
	
	@Id
	@Column(name="dept_id")
	private long deptId;
	
	@Column(name="dept_name")
	private String deptName;
	
	@JsonFormat(pattern="MM/dd/yyyy HH:mm")
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
	@CreatedDate
	private LocalDateTime createdDate;
	
	@JsonFormat(pattern="MM/dd/yyyy HH:mm")
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;
	
	@OneToMany
	@JoinColumn(name="loc_id")
	@JsonIgnore
	private List<LocationEntity> locations;
	
	@OneToOne(mappedBy="departmentEntity",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private EmployeeEntity employeeEntity;
	
	public DepartmentEntity()
	{
		
	}

	public DepartmentEntity(long deptId, String deptName, List<LocationEntity> locations,
			EmployeeEntity employeeEntity) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.locations = locations;
		this.employeeEntity = employeeEntity;
	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

	public List<LocationEntity> getLocations() {
		return locations;
	}

	public void setLocations(List<LocationEntity> locations) {
		this.locations = locations;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

}
