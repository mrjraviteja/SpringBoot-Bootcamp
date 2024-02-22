package com.mrj.springpoc.service;

import java.util.List;
import java.util.Optional;

import com.mrj.springpoc.entity.ItemEntity;

public interface ItemService {

	public List<ItemEntity> findAllItems();
	public Optional<ItemEntity> findItemById(Long id);
	
}
