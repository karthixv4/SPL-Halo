package com.spl.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spl.model.FixturesDO;
import com.spl.repository.FixturesRepo;
import com.spl.service.FixturesService;

@RestController
@RequestMapping("fixture")
public class FixtureController {

	@Autowired
	private FixturesService fixtureService;
	@Autowired
	private FixturesRepo fixtureRepo;
	
	@PostMapping("/saveFixture")
	public FixturesDO saveFixture(@RequestBody FixturesDO fixturesDO) {
		fixtureService.addFixture(fixturesDO);
		return fixturesDO;
	}
	@GetMapping("/getFixture")
	public FixturesDO getFixtureById(@RequestParam ObjectId id) {
		return fixtureService.getFixtureById(id);
	}
	@GetMapping("/getAllFixture")
	public List<FixturesDO> getAllFixtures(){
		return fixtureService.getAllFixtures();
	}
	
	@PutMapping("/updateFixture")
	public FixturesDO updateFixture(@RequestParam ObjectId id, @RequestBody FixturesDO fixturesDO) {
		 boolean exist = fixtureRepo.existsById(id);
		  if(exist) {
			  System.out.println("EXISTS");
			  fixtureService.addFixture(fixturesDO);
		  }
		  return fixturesDO;  
	}
	@DeleteMapping("/deleteFixture")
	public void deleteFixture(@RequestParam ObjectId id) {
		FixturesDO fixturesDO = fixtureService.getFixtureById(id);
		fixtureService.removeFixture(fixturesDO);
	}
}
