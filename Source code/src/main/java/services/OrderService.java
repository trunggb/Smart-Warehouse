package services;

import java.util.List;

import javax.persistence.TypedQuery;

import entities.Order;

public class OrderService extends GenericService<Order>{
	public OrderService() {
		super();
	}
	public List<Order> findAll() {
		TypedQuery<Order> q = em.createNamedQuery("findAllOrder", Order.class);
		return q.getResultList();
	}
}
