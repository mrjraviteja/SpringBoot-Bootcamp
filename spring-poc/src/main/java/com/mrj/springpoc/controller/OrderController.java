package com.mrj.springpoc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.springpoc.entity.OrderEntity;
import com.mrj.springpoc.service.OrderService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<Object> showAllOrders()
	{
		List<OrderEntity> orders = orderService.findAllOrders();
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> showOrderById(@PathVariable(value="id") long id)
	{
		Optional<OrderEntity> order = orderService.findOrderById(id);
		if(order.isPresent())
		{
			OrderEntity orderresp = order.get();
			return ResponseEntity.status(HttpStatus.FOUND).body(orderresp);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order does not exist!");
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> addOrder(@RequestBody OrderEntity orderEntity)
	{
		OrderEntity order = orderService.addOrder(orderEntity);
		if(order == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Failed to add order!");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateOrder(@PathVariable(value="id") long id,@RequestBody OrderEntity orderEntity)
	{
		Optional<OrderEntity> orderresp = orderService.findOrderById(id);
		if(orderresp.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to find course!");
		}
		OrderEntity oldorder = orderresp.get();
		OrderEntity savedEntity = orderService.updateOrder(oldorder, orderEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
	}
	
}
