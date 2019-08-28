package services;

import java.util.List;
import java.util.Optional;

import bom.Travel;
import entities.TravelEntity;

public class TravelService extends GenericService<TravelEntity, Travel>{
	public TravelService() {
		super();
	}
	@Override
	public Optional<TravelEntity> toEntity(Travel bom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Travel> toBom(TravelEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Travel> toBoms(List<TravelEntity> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TravelEntity> toEntities(List<Travel> boms) {
		// TODO Auto-generated method stub
		return null;
	}

}
