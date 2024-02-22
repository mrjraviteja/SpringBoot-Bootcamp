package com.mrj.springpoc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mrj.springpoc.entity.ItemEntity;
import com.mrj.springpoc.repository.ItemRepository;
import com.mrj.springpoc.service.ItemService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService{
	
	private ItemRepository itemRepository;

	@Override
	public List<ItemEntity> findAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public Optional<ItemEntity> findItemById(Long id) {
		return itemRepository.findById(id);
	}

}
