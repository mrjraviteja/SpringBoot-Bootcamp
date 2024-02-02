package com.mrj.employeemanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.employeemanagement.controller.dto.LocationResponseDTO;
import com.mrj.employeemanagement.service.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController {
	
	private final LocationService locationService;

	public LocationController(LocationService locationService) {
		super();
		this.locationService = locationService;
	}
	
	@GetMapping()
	public List<LocationResponseDTO> findAllLocations()
	{
		return locationService.findAllLocations();
	}
}
