package services;

import java.util.List;
import java.util.Optional;

import bom.Log;
import entities.LogEntity;

public class LogService extends GenericService<LogEntity, Log>{
	public LogService() {
		super();
	}
	
	@Override
	public Optional<LogEntity> toEntity(Log bom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Log> toBom(LogEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Log> toBoms(List<LogEntity> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogEntity> toEntities(List<Log> boms) {
		// TODO Auto-generated method stub
		return null;
	}

}
