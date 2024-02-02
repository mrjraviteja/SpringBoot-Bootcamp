package com.mrj.employeemanagement.controller.dto;

import java.util.List;

import com.mrj.employeemanagement.entity.LocationEntity;

public class DepartmentResponseDTO {
	
	private long deptId;
	private String deptName;
	private List<LocationEntity> locations;
	
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
	
}
