package com.happy.game.lostcity.domain.users;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long>{

	boolean existsById(String id);    
	UserEntity findById(String id);
}
