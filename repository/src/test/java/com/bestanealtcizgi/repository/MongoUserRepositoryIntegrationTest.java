package com.bestanealtcizgi.repository;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bestanealtcizgi.entity.UserEntity;
import com.bestanealtcizgi.entity.UserStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:repository-beans.xml" })
public class MongoUserRepositoryIntegrationTest {

	@Autowired
	MongoOperations operations;

	@Autowired
	UserRepository userRepository;

	@Before
	public void setUp() {
		operations.dropCollection(UserEntity.class);
	}

	@Test
	public void testSave() {
		UserEntity userEntity = saveEntity();

		List<UserEntity> actual = operations.findAll(UserEntity.class);

		Assert.assertNotNull(actual);
		Assert.assertEquals(1, actual.size());
		UserEntity actualEntity = actual.get(0);
		Assert.assertNotNull(actualEntity.getId());
		Assert.assertEquals(userEntity.getEmail(), actualEntity.getEmail());
	}

	@Test
	public void testUpdate() {
		UserEntity userEntity = saveEntity();

		userEntity.setStatus(UserStatus.PASSIVE);

		userRepository.save(userEntity);

		List<UserEntity> actual = operations.findAll(UserEntity.class);

		Assert.assertNotNull(actual);
		Assert.assertEquals(1, actual.size());
		UserEntity actualEntity = actual.get(0);
		Assert.assertNotNull(actualEntity.getId());
		Assert.assertEquals(UserStatus.PASSIVE, actualEntity.getStatus());
	}

	private UserEntity saveEntity() {
		UserEntity userEntity = new UserEntity();

		userEntity.setEmail("umutcelik@gmail.com");
		userEntity.setName("umut");
		userEntity.setSurname("celik");
		userEntity.setStatus(UserStatus.ACTIVE);

		userRepository.save(userEntity);
		return userEntity;
	}

}
