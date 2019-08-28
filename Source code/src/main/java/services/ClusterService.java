package services;

import java.util.List;
import java.util.Optional;

import bom.Cluster;
import entities.ClusterEntity;

public class ClusterService extends GenericService<ClusterEntity, Cluster>{
	public ClusterService() {
		super();
	}
	
	@Override
	public Optional<ClusterEntity> toEntity(Cluster bom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cluster> toBom(ClusterEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cluster> toBoms(List<ClusterEntity> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClusterEntity> toEntities(List<Cluster> boms) {
		// TODO Auto-generated method stub
		return null;
	}

}
