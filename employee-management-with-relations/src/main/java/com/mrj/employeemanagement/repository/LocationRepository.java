package com.mrj.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrj.employeemanagement.entity.LocationEntity;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long>{

}
