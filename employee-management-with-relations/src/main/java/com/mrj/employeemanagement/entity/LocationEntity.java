package com.mrj.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="mt_loc")
public class LocationEntity {
	
	@Id
	@Column(name="loc_id")
	private long locId;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	@Column(name="pin")
	private int pin;
	
	@ManyToOne
	@JoinColumn(name="loc_id",updatable=false,insertable=false)
	@JsonIgnore
	private DepartmentEntity departmentEntity;
	
	
	public LocationEntity()
	{
		
	}

	public LocationEntity(long locId, String city, String state, String country, int pin,
			DepartmentEntity departmentEntity) {
		super();
		this.locId = locId;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
		this.departmentEntity = departmentEntity;
	}

	public long getLocId() {
		return locId;
	}

	public void setLocId(long locId) {
		this.locId = locId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public DepartmentEntity getDepartmentEntity() {
		return departmentEntity;
	}

	public void setDepartmentEntity(DepartmentEntity departmentEntity) {
		this.departmentEntity = departmentEntity;
	}
	
}
