package services;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.lin.faker.Faker;

import entities.Product;

@Stateless
public class ProductService extends GenericService<Product> {
	@EJB
	TypeProductService typeProductService;

	public ProductService() {
		super();
	}

	public boolean add(Product product) {
		return this.create(product);
	}

	public boolean update(Product product) {
		return this.update(product);
	}
	
	public boolean remove(Product product) {
		return this.delete(product);
	}
	
	
	public Optional<Product> find(int id){
		if(id >= 0) {
			Product ret = this.em.find(Product.class, id);
			if(ret != null) {
				return Optional.of(ret);
			}
		}
		return Optional.empty();
	}
	
	public List<Product> findAll() {
		TypedQuery<Product> q = em.createNamedQuery("findAllProduct", Product.class);
		return q.getResultList();
	}
}
