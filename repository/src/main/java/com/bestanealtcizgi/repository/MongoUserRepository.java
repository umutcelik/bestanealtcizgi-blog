package com.bestanealtcizgi.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.bestanealtcizgi.entity.UserEntity;
import com.bestanealtcizgi.entity.UserStatus;

@Repository
public class MongoUserRepository implements UserRepository {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MongoUserRepository.class);

	@Autowired
	private MongoOperations operations;

	@Override
	public void save(UserEntity userEntity) {
		operations.save(userEntity);

	}

	@Override
	public UserEntity get(ObjectId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ObjectId id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UserEntity userEntity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> findByStatus(UserStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

}
