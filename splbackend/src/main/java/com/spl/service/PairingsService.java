package com.spl.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spl.model.PairingsDO;
import com.spl.repository.PairingsRepo;

@Service
public class PairingsService {

	@Autowired
	private PairingsRepo pairingsRepo;
	
	public void addFixture(PairingsDO pairingsDO) {
		pairingsRepo.save(pairingsDO);
	}
	
	public PairingsDO getFixtureById(ObjectId id) {
		return pairingsRepo.findById(id);
	}
	
	public void removeFixture(PairingsDO pairingsDO) {
		pairingsRepo.delete(pairingsDO);
	}
	
	public List<PairingsDO> getAllPairings(){
		return pairingsRepo.findAll();
		}
}
