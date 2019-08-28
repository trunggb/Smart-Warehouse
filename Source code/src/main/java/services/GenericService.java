package services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericService <E,B>{

	@PersistenceContext(name="SmartWarehouse")
	EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public EntityManager getEm() {
		return this.em;
	}
	public void save(E entity) {
		if(entity != null) {
			em.persist(entity);
		}
	}
	
	public void update (E entity){
		if(entity != null) {
			em.merge(entity);
		}
	}
	public void remove(E entity) {
		if(entity != null) {
			em.remove(entity);
		}
	}
	public abstract Optional<E> toEntity(B bom);
	
	public abstract Optional<B> toBom(E entity);
	
	public abstract List<B> toBoms(List<E> entities);
	
	public abstract List<E> toEntities(List<B> boms);
}
