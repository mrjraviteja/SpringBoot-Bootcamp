package com.mrj.employeemanagement.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrj.employeemanagement.entity.LocationEntity;

public class DepartmentResponseDTO {
	
	private long deptId;
	private String deptName;
	private List<LocationEntity> locations;
	
	@JsonFormat(pattern = "MM/dd/yyyy HH:mm")
    private LocalDateTime createdDate;
    
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm")
    private LocalDateTime lastModifiedDate;
	
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
	public List<LocationEntity> getLocations() {
		return locations;
	}
	public void setLocations(List<LocationEntity> locations) {
		this.locations = locations;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
