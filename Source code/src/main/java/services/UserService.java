package services;

import java.util.List;
import java.util.Optional;

import bom.User;
import entities.UserEntity;

public class UserService extends GenericService<UserEntity, User>{
	public UserService() {
		super();
	}
	
	@Override
	public Optional<UserEntity> toEntity(User bom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> toBom(UserEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> toBoms(List<UserEntity> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> toEntities(List<User> boms) {
		// TODO Auto-generated method stub
		return null;
	}

}
