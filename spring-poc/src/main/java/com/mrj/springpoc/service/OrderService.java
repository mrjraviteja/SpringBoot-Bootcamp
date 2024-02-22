package com.mrj.springpoc.service;

import java.util.List;
import java.util.Optional;

import com.mrj.springpoc.entity.OrderEntity;

public interface OrderService {
	
	public List<OrderEntity> findAllOrders();
	public Optional<OrderEntity> findOrderById(Long id);
	public OrderEntity addOrder(OrderEntity orderEntity);
	public OrderEntity updateOrder(OrderEntity oldOrderEntity,OrderEntity newOrderEntity);
}
