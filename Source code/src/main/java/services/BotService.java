package services;

import java.util.List;
import java.util.Optional;

import bom.Bot;
import entities.BotEntity;

public class BotService extends GenericService<BotEntity, Bot>{
	public BotService() {
		super();
	}
	
	@Override
	public Optional<BotEntity> toEntity(Bot bom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Bot> toBom(BotEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bot> toBoms(List<BotEntity> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BotEntity> toEntities(List<Bot> boms) {
		// TODO Auto-generated method stub
		return null;
	}

}
