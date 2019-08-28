package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import bom.Product;
import entities.ProductEntity;

@Stateless
public class ProductService extends GenericService<ProductEntity, Product> {
	@EJB
	TypeProductService typeProductService;

	public ProductService() {
		super();
	}

	public void add(ProductEntity productEntity) {
		this.save(productEntity);
	}

	public void updateProduct(ProductEntity productEntity) {
		this.update(productEntity);
	}

	public List<ProductEntity> findAll() {
		TypedQuery<ProductEntity> q = em.createNamedQuery("findAllProduct", ProductEntity.class);
		return q.getResultList();
	}

	public Optional<ProductEntity> findById(int id) {
		return Optional.of(em.find(ProductEntity.class, id));
	}

	@Override
	public Optional<ProductEntity> toEntity(Product bom) {
		if (bom != null) {
			return Optional.of(new ProductEntity(bom.getId(), bom.getName(),
					typeProductService.toEntity(bom.getTypeProduct()).get(), bom.getImage(), bom.getWeight(),
					bom.getAmount(), bom.getStatus(), bom.getInDate(), bom.getOutDate(), bom.getExpiryDate()));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Product> toBom(ProductEntity entity) {
		if (entity != null) {
			return Optional.of(new Product(entity.getId(), entity.getName(),
					typeProductService.toBom(entity.getTypeProduct()).get(), entity.getImage(), entity.getWeight(),
					entity.getAmount(), entity.getStatus(), entity.getInDate(), entity.getOutDate(),
					entity.getExpiryDate()));
		}
		return Optional.empty();
	}

	@Override
	public List<Product> toBoms(List<ProductEntity> entities) {
		if (!entities.isEmpty()) {
			List<Product> boms = new ArrayList<>();
			for (ProductEntity entity : entities) {
				if (toBom(entity).isPresent()) {
					boms.add(toBom(entity).get());
				}
			}
			return boms;
		}
		return Collections.emptyList();
	}

	@Override
	public List<ProductEntity> toEntities(List<Product> boms) {
		if (!boms.isEmpty()) {
			List<ProductEntity> entities = new ArrayList<>();
			for (Product bom : boms) {
				if (toEntity(bom).isPresent()) {
					entities.add(toEntity(bom).get());
				}
			}
			return entities;
		}
		return Collections.emptyList();
	}

}
