package services;

import java.util.List;
import java.util.Optional;

import bom.OrderDetail;
import entities.OrderDetailEntity;

public class OrderDetailService extends GenericService<OrderDetailEntity, OrderDetail>{
	public OrderDetailService() {
		super();
	}
	
	@Override
	public Optional<OrderDetailEntity> toEntity(OrderDetail bom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<OrderDetail> toBom(OrderDetailEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> toBoms(List<OrderDetailEntity> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailEntity> toEntities(List<OrderDetail> boms) {
		// TODO Auto-generated method stub
		return null;
	}

}
