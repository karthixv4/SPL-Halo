package com.spl.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spl.model.FixturesDO;
@Repository
public interface FixturesRepo extends MongoRepository<FixturesDO, String> {

	FixturesDO findById(ObjectId id);
	boolean existsById(ObjectId objectId);
}
