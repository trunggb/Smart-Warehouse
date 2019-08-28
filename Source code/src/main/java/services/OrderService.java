package services;

import java.util.List;
import java.util.Optional;

import bom.Order;
import entities.OrderEntity;

public class OrderService extends GenericService<OrderEntity, Order>{
	public OrderService() {
		super();
	}
	
	@Override
	public Optional<OrderEntity> toEntity(Order bom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Order> toBom(OrderEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> toBoms(List<OrderEntity> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderEntity> toEntities(List<Order> boms) {
		// TODO Auto-generated method stub
		return null;
	}

}
