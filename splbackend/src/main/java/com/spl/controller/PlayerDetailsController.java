package com.spl.controller;


import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spl.model.PlayerDO;
import com.spl.repository.PlayerDetailsRepo;
import com.spl.service.PlayerDetailsService;

@RestController
@RequestMapping("player")
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerDetailsController {

	@Autowired
	private PlayerDetailsService playerDetailsService;
	
	@Autowired
	private PlayerDetailsRepo playerDetailsRepo;
	
	@GetMapping("/test")
	public String getTestAPI(){
	        return "TESTED";
	    }
	  
	@PostMapping("/savePlayer")
	public String savePlayer(@RequestBody PlayerDO playerDO) {
		  playerDetailsService.addPlayer(playerDO);
		  System.out.println(playerDO.toString());
		  return "success";
	  }
	  
	@PutMapping("/updatePlayer")
	public PlayerDO updatePlayer(@RequestBody PlayerDO playerDO) {
		
		System.out.println("ID:"+playerDO.getId());
//		  boolean exist = playerDetailsRepo.existsById(id);
		boolean exist = true;
		  System.out.println("exist:"+exist);
		  if(exist) {
			  System.out.println("EXISTS");
			  playerDetailsService.addPlayer(playerDO);
		  }
		  return playerDO;  
	  }
	  @GetMapping("/getAllPlayers")
	  public List<PlayerDO> getAllPlayers(){
		return  playerDetailsService.getAllPlayers();
	  }
	  
	  @GetMapping("/getPlayer")
	  public PlayerDO getPlayerById(@RequestParam String id) {
		  return playerDetailsService.findPlayerById(id);
	  }
	  
	  @DeleteMapping("/deletePlayer")
	  public void deletePlayer(@RequestParam String id) {
		  PlayerDO player = playerDetailsService.findPlayerById(id);
		  playerDetailsService.deletePlayer(player);
	  }
	  
}
