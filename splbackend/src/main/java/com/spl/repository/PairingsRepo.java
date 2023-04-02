package com.spl.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spl.model.PairingsDO;
@Repository
public interface PairingsRepo extends MongoRepository<PairingsDO, String> {
	PairingsDO findById(ObjectId id);
	boolean existsById(ObjectId objectId);
}
