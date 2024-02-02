package com.mrj.employeemanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mrj.employeemanagement.controller.dto.LocationResponseDTO;
import com.mrj.employeemanagement.entity.LocationEntity;
import com.mrj.employeemanagement.repository.LocationRepository;
import com.mrj.employeemanagement.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{

	private final LocationRepository locationRepository;
	
	public LocationServiceImpl(LocationRepository locationRepository) {
		super();
		this.locationRepository = locationRepository;
	}

	@Override
	public List<LocationResponseDTO> findAllLocations() {
		List<LocationEntity> locations = locationRepository.findAll();
		return locations.stream().map(this::mapToLocationResponseDTO).collect(Collectors.toList());
	}
	
	private LocationResponseDTO mapToLocationResponseDTO(LocationEntity locationEntity)
	{
		LocationResponseDTO responseDTO = new LocationResponseDTO();
		responseDTO.setLocId(locationEntity.getLocId());
		responseDTO.setCity(locationEntity.getCity());
        responseDTO.setState(locationEntity.getState());
        responseDTO.setCountry(locationEntity.getCountry());
        responseDTO.setPin(locationEntity.getPin());
        
        return responseDTO;
	}
	
}
