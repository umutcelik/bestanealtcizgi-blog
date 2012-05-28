package com.bestanealtcizgi.repository;

import java.util.List;

import org.bson.types.ObjectId;

import com.bestanealtcizgi.entity.UserEntity;
import com.bestanealtcizgi.entity.UserStatus;

public interface UserRepository {

	public void save(UserEntity userEntity);

	public UserEntity get(ObjectId id);

	public void delete(ObjectId id);

	public void delete(UserEntity userEntity);

	public List<UserEntity> findAll();

	public UserEntity findByEmail(String email);

	public List<UserEntity> findByStatus(UserStatus status);

}
