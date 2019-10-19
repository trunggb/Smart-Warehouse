package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import entities.User;

@Stateless
public class UserService extends GenericService<User>{
	public UserService() {
		super();
	}
	public boolean add(User user) {
		return this.create(user);
	}
	
	List<User> findAll(){
		TypedQuery<User> q = em.createNamedQuery("findAllUser",User.class);
		return q.getResultList();
	}
	
	public boolean checkValidUser(User user) {
		return true;
	}
}
