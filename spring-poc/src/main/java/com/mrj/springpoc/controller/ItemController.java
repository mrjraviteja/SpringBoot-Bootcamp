package com.mrj.springpoc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.springpoc.entity.ItemEntity;
import com.mrj.springpoc.service.ItemService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/items")
public class ItemController {

	private ItemService itemService;
	
	@GetMapping
	public ResponseEntity<Object> findAllItems()
	{
		List<ItemEntity> items = itemService.findAllItems();
		return ResponseEntity.status(HttpStatus.OK).body(items);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findItemById(@PathVariable(value="id") long id)
	{
		Optional<ItemEntity> item = itemService.findItemById(id);
		if(item.isPresent())
		{
			ItemEntity itemresp = item.get();
			return ResponseEntity.status(HttpStatus.FOUND).body(itemresp);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found!");
		}
	}
}
