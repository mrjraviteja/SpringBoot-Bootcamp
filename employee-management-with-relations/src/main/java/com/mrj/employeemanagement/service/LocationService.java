package com.mrj.employeemanagement.service;

import java.util.List;

import com.mrj.employeemanagement.controller.dto.LocationResponseDTO;

public interface LocationService {
	List<LocationResponseDTO> findAllLocations();
}
