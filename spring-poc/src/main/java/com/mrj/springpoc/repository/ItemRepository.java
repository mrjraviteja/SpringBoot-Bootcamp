package com.mrj.springpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrj.springpoc.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long>{

}
