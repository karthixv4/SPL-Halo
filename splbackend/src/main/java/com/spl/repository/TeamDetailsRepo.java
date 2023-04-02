package com.spl.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spl.model.TeamDO;

@Repository
public interface TeamDetailsRepo extends MongoRepository<TeamDO, String> {

	TeamDO findById(ObjectId id);
	
	 boolean existsById(ObjectId objectId);

}
