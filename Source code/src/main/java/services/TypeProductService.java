package services;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;

import bom.TypeProduct;
import entities.ProductEntity;
import entities.TypeProductEntity;

@Stateless
public class TypeProductService extends GenericService<TypeProductEntity,TypeProduct>{
	public TypeProductService() {
		super();
	}
	@Override
	public Optional<TypeProductEntity> toEntity(TypeProduct bom) {
		if (bom != null) {
			return Optional.of(new TypeProductEntity(bom.getId(), bom.getName(), bom.getUnit()));
		}
		return Optional.empty();
	}

	@Override
	public Optional<TypeProduct> toBom(TypeProductEntity entity) {
		if(entity != null) {
			return Optional.of(new TypeProduct(entity.getId(), entity.getName(), entity.getUnit()));
		}
		return Optional.empty();
	}

	@Override
	public List<TypeProduct> toBoms(List<TypeProductEntity> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeProductEntity> toEntities(List<TypeProduct> boms) {
		// TODO Auto-generated method stub
		return null;
	}

}
