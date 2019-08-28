package services;

import java.util.List;
import java.util.Optional;

import bom.Location;
import entities.LocationEntity;

public class LocationService extends GenericService<LocationEntity, Location>{
	public LocationService() {
		super();
	}
	
	@Override
	public Optional<LocationEntity> toEntity(Location bom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Location> toBom(LocationEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> toBoms(List<LocationEntity> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocationEntity> toEntities(List<Location> boms) {
		// TODO Auto-generated method stub
		return null;
	}

}
