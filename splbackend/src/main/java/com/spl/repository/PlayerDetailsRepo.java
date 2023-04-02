package com.spl.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spl.model.PlayerDO;

@Repository
public interface PlayerDetailsRepo extends MongoRepository<PlayerDO, Long> {

	 boolean existsById(ObjectId objectId);
	 
	 List<PlayerDO> findByName(String Name);
	 
	 PlayerDO findById(String id);
}
