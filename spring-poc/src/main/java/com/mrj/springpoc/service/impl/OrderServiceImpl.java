package com.mrj.springpoc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mrj.springpoc.entity.ItemEntity;
import com.mrj.springpoc.entity.OrderEntity;
import com.mrj.springpoc.repository.ItemRepository;
import com.mrj.springpoc.repository.OrderRepository;
import com.mrj.springpoc.service.OrderService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
	
	private OrderRepository orderRepository;
	private ItemRepository itemRepository;

	@Override
	public List<OrderEntity> findAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<OrderEntity> findOrderById(Long id) {
		return orderRepository.findById(id);
	}

	@Override
	public OrderEntity addOrder(OrderEntity orderEntity) {
		
		List<ItemEntity> items = orderEntity.getOrderItems();
		items.forEach(item -> item.setOrderEntity(orderEntity));
		return orderRepository.save(orderEntity);
	}

	@Override
	public OrderEntity updateOrder(OrderEntity oldOrderEntity,OrderEntity newOrderEntity) {
		List<ItemEntity> items = oldOrderEntity.getOrderItems();
		List<Long> ids = new ArrayList<>();
		for(ItemEntity entity : items) {
			ids.add(entity.getId());
		}
		itemRepository.deleteAllByIdInBatch(ids);
		oldOrderEntity.setOrderedBy(newOrderEntity.getOrderedBy());
		oldOrderEntity.setOrderItems(newOrderEntity.getOrderItems());
		return addOrder(oldOrderEntity);
	}

}
