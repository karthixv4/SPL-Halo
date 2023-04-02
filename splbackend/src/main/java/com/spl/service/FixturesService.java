package com.spl.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spl.model.FixturesDO;
import com.spl.repository.FixturesRepo;

@Service
public class FixturesService {

	@Autowired
	private FixturesRepo fixturesRepo;
	
	public void addFixture(FixturesDO fixturesDO) {
		fixturesRepo.save(fixturesDO);
	}
	
	public FixturesDO getFixtureById(ObjectId id) {
		return fixturesRepo.findById(id);
	}
	
	public void removeFixture(FixturesDO fixturesDO) {
		fixturesRepo.delete(fixturesDO);
	}
	
	public List<FixturesDO> getAllFixtures(){
		return fixturesRepo.findAll();
		}
}
