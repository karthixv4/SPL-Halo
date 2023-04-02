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

import com.spl.model.PairingsDO;
import com.spl.repository.PairingsRepo;
import com.spl.service.PairingsService;

@RestController
@RequestMapping("pairings")
public class PairingsController {

	@Autowired
	private PairingsService pairingsService;
	
	@Autowired
	private PairingsRepo pairingsRepo;
	
	@PostMapping("/saveFixture")
	public PairingsDO saveFixture(@RequestBody PairingsDO pairingsDO) {
		pairingsService.addFixture(pairingsDO);
		return pairingsDO;
	}
	@GetMapping("/getFixture")
	public PairingsDO getFixtureById(@RequestParam ObjectId id) {
		return pairingsService.getFixtureById(id);
	}
	@GetMapping("/getAllFixture")
	public List<PairingsDO> getAllFixtures(){
		return pairingsService.getAllPairings();
	}
	
	@PutMapping("/updateFixture")
	public PairingsDO updateFixture(@RequestParam ObjectId id, @RequestBody PairingsDO pairingsDO) {
		 boolean exist = pairingsRepo.existsById(id);
		  if(exist) {
			  System.out.println("EXISTS");
			  pairingsService.addFixture(pairingsDO);
		  }
		  return pairingsDO;  
	}
	@DeleteMapping("/deleteFixture")
	public void deleteFixture(@RequestParam ObjectId id) {
		PairingsDO pairingsDO = pairingsService.getFixtureById(id);
		pairingsService.removeFixture(pairingsDO);
	}
}
